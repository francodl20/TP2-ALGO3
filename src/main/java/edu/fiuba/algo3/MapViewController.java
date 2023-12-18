package edu.fiuba.algo3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MapViewController implements IController{
    
    private GameController gameController;
    private Integer mapHeight;
    private Integer mapWidth;
    private LinkedList<ISquare> walkableSquares;
    private List<ImageView> playersAvatars;

    GridPane mapGrid;

    @FXML
    StackPane mapStack;

    public void setGame(GameController game) {
        gameController = game;

        Coordinate mapSize = gameController.getMapSize();
        mapHeight = mapSize.getYValue();
        mapWidth = mapSize.getXValue();
        walkableSquares = gameController.getSquares();
        playersAvatars = new LinkedList<>();

        mapGrid = new GridPane();
        mapStack.getChildren().add(mapGrid);

        setPlayersAvatars();

        showMap(0);
    }
   
    private void showMap(Integer mainPlayerPosition) {
        List<Gladiator> players = gameController.getPlayers();

        Image walkableImage = new Image("file:src/main/resources/images/rockTile.png");
        Image nonWalkableImage = new Image("file:src/main/resources/images/lavaOMG.png");

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
