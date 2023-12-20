package edu.fiuba.algo3.UI;

import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.GameMenuBar;
import edu.fiuba.algo3.controller.Controller;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.Gladiator;

import java.util.*;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;



public class MapProv extends BorderPane{

    
    private Integer mapWidth;
    private Integer mapHeight;
    private Controller controller;
    private LinkedList<ISquare> walkableSquares;
    private List<ImageView> playersAvatars;
    private Image walkableImage;
    private Image nonWalkableImage;
    
    public MapProv(LinkedList<ISquare> squares, Coordinate mapSize, Controller controller) {
        
        
        this.mapWidth = mapSize.getXValue();
        this.mapHeight = mapSize.getYValue();
        this.controller = controller;
        this.walkableSquares = squares;
        this.playersAvatars = new LinkedList<>();
        
        if (mapWidth <= 0 || mapHeight <= 0) {
            throw new IllegalArgumentException("Dimensiones del mapa deben ser mayores que cero");
        }

        walkableImage = new Image("file:src/main/resources/images/rockTile.png");
        nonWalkableImage =  new Image("file:src/main/resources/images/lavaOMG.png");
        
       

        setPlayersAvatars();
        drawGame(new GridPane(), 0, controller.getPlayers().get(0));

}   

    public void drawGame(GridPane mapPane, Integer mainPlayerPosition, Gladiator currentPlayer ){
     
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 14);

        MenuBar menuBar = GameMenuBar.createMenuBar(controller.getStage(), controller);
        this.setTop(menuBar);

       
        VBox borderBox = new VBox();
        this.setLeft(borderBox);
        borderBox.setSpacing(30);
        borderBox.setPadding(new Insets(10));
        
        
        Label playerNameLabel = new Label("Jugador actual: " + currentPlayer.getName());
        playerNameLabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 12; -fx-text-fill: #ffffff;");
        Label seniorityLabel = new Label("Seniority: " + currentPlayer.getSeniority());
        seniorityLabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 12; -fx-text-fill: #ffffff;");
        Label energyLabel = new Label("Energía: " + currentPlayer.getEnergy());
        energyLabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 12; -fx-text-fill: #ffffff;");
        Label stateLabel = new Label("Estado: " + currentPlayer.getPlayerState());
        stateLabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 12; -fx-text-fill: #ffffff;");
        Label equipmentLabel = new Label("Equipamiento: " + currentPlayer.getEquipment());
        equipmentLabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 12; -fx-text-fill: #ffffff;");
       

        Button diceButton = new Button("Tirar dado");
        diceButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        diceButton.setFont(customFont);
    

        
        diceButton.setOnAction(event -> {
            controller.movePlayer();
        });
    
        Button goBackButton = new Button("Volver");
        goBackButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        goBackButton.setFont(customFont);
      

        
        goBackButton.setOnAction(event -> {
            
            //UserInformationScreen screen = new UserInformationScreen(controller);
            //screen.requestAmountOfPlayers(new Stage());
            DiceView screen = new DiceView(controller);
            screen.requestPreferedDice(controller.getStage());
           // controller.getStage().close();
        });

        borderBox.getChildren().addAll(playerNameLabel, seniorityLabel,energyLabel,equipmentLabel, stateLabel, diceButton, goBackButton);
       
        drawMap(mapPane, mainPlayerPosition);
        this.setCenter(mapPane);
    }
    
    public void drawMap(GridPane mapPane, Integer mainPlayerPosition) {
        List<Gladiator> players = controller.getPlayers();
        for (int y = 1; y <= mapHeight; y++) {
            for (int x = 1; x <= mapWidth; x++) {
                StackPane cellPane = new StackPane();
                ImageView tile = new ImageView(); 
                tile.setFitWidth(50);
                tile.setFitHeight(50);

                if (isAWalkableSquare(x, y)) {
                 
                    tile.setImage(walkableImage);
                    cellPane.getChildren().add(tile);
                    
                    for (int i = 0; i < players.size(); i++) {

                        if (getSquarePosition(x,y) == (players.get(i).getPosition() - 1)) {
                            cellPane.getChildren().add(playersAvatars.get(i));
                        }
                    }
                } else {
            
                    tile.setImage(nonWalkableImage);
                    cellPane.getChildren().add(tile);
                } 
            
                mapPane.add(cellPane, x, y);
            }
             
        }    
            if(mainPlayerPosition > 0){
                
            System.out.println(mainPlayerPosition);
            controller.showSquareInfo(walkableSquares.get(mainPlayerPosition - 1).getObstacleType(),walkableSquares.get(mainPlayerPosition - 1).getPrizeType());
        }

    }
    
    private int getSquarePosition(int x, int y) {
       
        Coordinate targetCoordinate = new Coordinate(x, y);
        int position = -1;
       
        for (int i = 0; i < walkableSquares.size(); i++) {
            if (walkableSquares.get(i).getSquareCoordinate().equals(targetCoordinate)) {
                position = i;
            }
        }

        return position;      
    }
    
    private boolean isAWalkableSquare(int x, int y) {
       
        Coordinate targetCoordinate = new Coordinate(x, y);
        boolean isWalkable = false;
       
        for (ISquare square : walkableSquares) {
            if (square.getSquareCoordinate().equals(targetCoordinate)) {
                isWalkable = true;
            }
        }

        return isWalkable;      
    }

    private void setPlayersAvatars(){

        for (Integer index = 0; index < controller.getPlayers().size(); index++) {
           playersAvatars.add(playerFactory(index + 1));
        }

    }

    private ImageView playerFactory(Integer numberOfPlayer){
        
        Map <Integer, ImageView> gladiators = new HashMap<>();

        ImageView firstGladiator = new ImageView("file:src/main/resources/images/gladiator.png");
        firstGladiator.setFitWidth(50);
        firstGladiator.setFitHeight(50);

        ImageView secondGladiator = new ImageView("file:src/main/resources/images/gladiator2.png");
        secondGladiator.setFitWidth(50);
        secondGladiator.setFitHeight(50);

        ImageView thirdGladiator = new ImageView("file:src/main/resources/images/gladiator3.png");
        thirdGladiator.setFitWidth(50);
        thirdGladiator.setFitHeight(50);

        ImageView fourthGladiator = new ImageView("file:src/main/resources/images/gladiator4.png");
        fourthGladiator.setFitWidth(50);
        fourthGladiator.setFitHeight(50);
        
        ImageView fifthGladiator = new ImageView("file:src/main/resources/images/gladiator5.png");
        fifthGladiator.setFitWidth(50);
        fifthGladiator.setFitHeight(50);
        
        ImageView sixthGladiator = new ImageView("file:src/main/resources/images/gladiator6.png");
        sixthGladiator.setFitWidth(50);
        sixthGladiator.setFitHeight(50);

        gladiators.put(1, firstGladiator);
        gladiators.put(2, secondGladiator);
        gladiators.put(3, thirdGladiator);
        gladiators.put(4, fourthGladiator);
        gladiators.put(5, fifthGladiator);
        gladiators.put(6, sixthGladiator);
        
        return  gladiators.get(numberOfPlayer);
    }

}


    
