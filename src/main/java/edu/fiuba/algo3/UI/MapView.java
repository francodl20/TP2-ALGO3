package edu.fiuba.algo3.UI;

import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.board.prizes.EmptyPrize;
import edu.fiuba.algo3.modelo.board.Parser;
import edu.fiuba.algo3.modelo.board.obstacles.EmptyObstacle;
import edu.fiuba.algo3.modelo.board.squares.PathSquare;
import edu.fiuba.algo3.modelo.attributes.Coordinate;

import java.util.*;

import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MapView extends GridPane{


    private Integer mapWidth;
    private Integer mapHeight;
    private LinkedList<ISquare> walkableSquares;

    public MapView(Integer mapWidth, Integer mapHeight/* , LinkedList<Square> walkableSquares*/) {
        if (mapWidth <= 0 || mapHeight <= 0) {
            throw new IllegalArgumentException("Dimensiones del mapa deben ser mayores que cero");
        }

        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.walkableSquares = new LinkedList<ISquare>();
        loadCoordinates();
        initializeMap();

    }

    public void adjustSceneDimension() {
       
        double tileSize = 40.0; // Tamaño de cada imagen en el mapa

        double sceneWidth = mapWidth * tileSize;
        double sceneHeight = mapHeight * tileSize;

        this.getScene().getWindow().setWidth(sceneWidth);
        this.getScene().getWindow().setHeight(sceneHeight);
    }

    public void loadCoordinates(){
        try {
            walkableSquares = Parser.buildFromJson("src/main/resources/JSONFiles/board.json");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void initializeMap() {
 
        for (int y = 1; y <= mapHeight; y++) {
            for (int x = 1; x <= mapWidth; x++) {
                ImageView tile = new ImageView(); 
                tile.setFitWidth(40);
                tile.setFitHeight(40);

                if (isAWalkableSquare(x, y)) {
                    Image walkableImage = new Image("file:src/main/resources/images/rockTile.png");
                    tile.setImage(walkableImage);
                } else {
                    Image nonWalkableImage = new Image("file:src/main/resources/images/sandTile.png");
                    tile.setImage(nonWalkableImage);
                } 

                this.add(tile, x, y);
            }
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
}


    
