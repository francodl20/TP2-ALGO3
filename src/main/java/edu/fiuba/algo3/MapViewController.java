package edu.fiuba.algo3;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;

import edu.fiuba.algo3.modelo.D10;
import edu.fiuba.algo3.modelo.D20;
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MapViewController implements Initializable{
    
    //Map
    private GameController gameController;
    private Integer mapHeight;
    private Integer mapWidth;
    private LinkedList<ISquare> walkableSquares;
    private List<ImageView> playersAvatars;

    GridPane mapGrid;

    @FXML
    ScrollPane scrollPane;

    @FXML
    SplitMenuButton diceButton;

    @FXML
    private void playWithD6() {
        gameController.playTurn(new D6());
        //setPlayerInformation() return player position
        Gladiator gladiator = gameController.getCurrentPlayer();
        showMap(gladiator.getPosition());
    }

    @FXML
    private void playWithD10() {
        gameController.playTurn(new D10());
        //setPlayerInformation() return player position
        Gladiator gladiator = gameController.getCurrentPlayer();
        showMap(gladiator.getPosition());
    }

    @FXML
    private void playWithD20() {
        gameController.playTurn(new D20());
        //setPlayerInformation() return player position
        Gladiator gladiator = gameController.getCurrentPlayer();
        showMap(gladiator.getPosition());
    }

    @FXML
    private void setD6() {
        diceButton.setText("D6");
        diceButton.setOnAction(event -> {playWithD6();});
    }

    @FXML
    private void setD10() {
        diceButton.setText("D10");
        diceButton.setOnAction(event -> {playWithD10();});
    }

    @FXML
    private void setD20() {
        diceButton.setText("D20");
        diceButton.setOnAction(event -> {playWithD20();});
    }


    private void showMap(Integer mainPlayerPosition) {
        List<Gladiator> players = gameController.getPlayers();

        Image walkableImage = new Image("file:src/main/resources/images/rockTile.png");
        Image nonWalkableImage = new Image("file:src/main/resources/images/grassTile.png");

        for (int y = 1; y <= mapHeight; y++) {
            for (int x = 1; x <= mapWidth; x++) {
                StackPane cellPane = new StackPane();
                ImageView tile = new ImageView(); 
                tile.setFitWidth(60);
                tile.setFitHeight(60);

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
            
                mapGrid.add(cellPane, x, y);
            }
        }
        
        if(mainPlayerPosition > 0){

            String obstacleType = walkableSquares.get(mainPlayerPosition - 1).getObstacleType();
            String prizeType = walkableSquares.get(mainPlayerPosition - 1).getPrizeType();
            //controller.showSquareInfo(walkableSquares.get(mainPlayerPosition - 1)
            //.getObstacleType(), walkableSquares.get(mainPlayerPosition - 1).getPrizeType());
        }
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

    private void setPlayersAvatars(){

        for (Integer index = 0; index < gameController.getPlayers().size(); index++) {
           playersAvatars.add(playerFactory(index + 1));
        }

    }

    private ImageView playerFactory(Integer numberOfPlayer){
        
        Map <Integer, ImageView> gladiators = new HashMap<>();

        ImageView firstGladiator = new ImageView("file:src/main/resources/images/gladiator.png");
        firstGladiator.setFitWidth(60);
        firstGladiator.setFitHeight(60);

        ImageView secondGladiator = new ImageView("file:src/main/resources/images/gladiator2.png");
        secondGladiator.setFitWidth(60);
        secondGladiator.setFitHeight(60);

        ImageView thirdGladiator = new ImageView("file:src/main/resources/images/gladiator3.png");
        thirdGladiator.setFitWidth(60);
        thirdGladiator.setFitHeight(60);

        ImageView fourthGladiator = new ImageView("file:src/main/resources/images/gladiator4.png");
        fourthGladiator.setFitWidth(60);
        fourthGladiator.setFitHeight(60);
        
        ImageView fifthGladiator = new ImageView("file:src/main/resources/images/gladiator6.png");
        fifthGladiator.setFitWidth(60);
        fifthGladiator.setFitHeight(60);
        
        ImageView sixthGladiator = new ImageView("file:src/main/resources/images/gladiator6.png");
        sixthGladiator.setFitWidth(60);
        sixthGladiator.setFitHeight(60);

        gladiators.put(1, firstGladiator);
        gladiators.put(2, secondGladiator);
        gladiators.put(3, thirdGladiator);
        gladiators.put(4, fourthGladiator);
        gladiators.put(5, fifthGladiator);
        gladiators.put(6, sixthGladiator);
        
        return  gladiators.get(numberOfPlayer);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameController = GameInfo.getGame();

        Coordinate mapSize = gameController.getMapSize();
        mapHeight = mapSize.getYValue();
        mapWidth = mapSize.getXValue();
        walkableSquares = gameController.getSquares();
        playersAvatars = new LinkedList<>();

        mapGrid = new GridPane();
        scrollPane.setBackground(new Background(
            new BackgroundFill(Color.BLACK, null , null)));     
        scrollPane.setContent(mapGrid);

        setPlayersAvatars();

        showMap(0);

        GameInfo.getSoundController().setSong("galactic");
    }
}
