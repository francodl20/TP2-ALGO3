package edu.fiuba.algo3.UI;

import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.board.Parser;
import edu.fiuba.algo3.controller.Controller;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.Gladiator;

import java.util.*;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;


public class MapView extends GridPane{

    
    private Integer mapWidth;
    private Integer mapHeight;
    private Controller controller;
    private LinkedList<ISquare> walkableSquares;
    //private List<String> playerNames;
    private List<ImageView> playersAvatars;
    //private List<Gladiator> players;
    //private List<Coordinate> playerPositions;
    
    public MapView(Integer mapWidth, Integer mapHeight, Controller controller/* , List<Gladiator> players*/) {
        if (mapWidth <= 0 || mapHeight <= 0) {
            throw new IllegalArgumentException("Dimensiones del mapa deben ser mayores que cero");
        }

        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.controller = controller;
        this.walkableSquares = new LinkedList<ISquare>();
       // this.playerNames = playerNames;
        //this.players = players;
       // this.playerPositions = new LinkedList<>();
        this.playersAvatars = new LinkedList<>();

        loadCoordinates();
        /*
         * 
         for (String splayer : playerNames) {
            playerPositions.add(walkableSquares.getFirst().getSquareCoordinate());
        }
        */
        
        setPlayersAvatars();
        drawMap(0);

        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 40);
       
       
        Button diceButton = new Button("Tirar dado");
        diceButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");

    
        diceButton.setPrefSize(180, 40);
        diceButton.setFont(customFont);
        this.add(diceButton,0, 5); 

        diceButton.setOnAction(event->{
            controller.movePlayer();
            //updatePlayerPosition();
            //drawMap();
        });

    }

    private void loadCoordinates(){
        try {
            walkableSquares = Parser.buildFromJson("src/main/resources/JSONFiles/board.json");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void drawMap(Integer mainPlayerPosition) {
        List<Gladiator> players = controller.getPlayers();
        for (int y = 1; y <= mapHeight; y++) {
            for (int x = 1; x <= mapWidth; x++) {
                StackPane cellPane = new StackPane();
                ImageView tile = new ImageView(); 
                tile.setFitWidth(50);
                tile.setFitHeight(50);

                if (isAWalkableSquare(x, y)) {
                    Image walkableImage = new Image("file:src/main/resources/images/rockTile.png");
                    tile.setImage(walkableImage);
                    cellPane.getChildren().add(tile);
                    
                    for (int i = 0; i < players.size(); i++) {

                        //Coordinate coord = controller.getPlayers().get(i).getPosition();
                        //if (coord.equals( new Coordinate(x, y))) {
                          //  cellPane.getChildren().add(playersAvatars.get(i));
                        //}
                        if (getSquarePosition(x,y) == (players.get(i).getPosition() - 1)) {
                            cellPane.getChildren().add(playersAvatars.get(i));
                        }
                    }
                } else {
                    Image nonWalkableImage = new Image("file:src/main/resources/images/lavaOMG.png");
                    tile.setImage(nonWalkableImage);
                    cellPane.getChildren().add(tile);
                } 
            
                this.add(cellPane, x, y);
            }
        }

        /*
         * 
         for (int i = 0; i < players.size(); i++) {
            
             this.add(playersAvatars.get(i), playerPositions.get(i).getXValue(), playerPositions.get(i).getYValue());
            }
            */


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

    private void waitFor(Stage stage, Integer seconds) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(seconds), ae -> stage.close()));
        timeline.setCycleCount(1);
        timeline.play();
    }

}


    
