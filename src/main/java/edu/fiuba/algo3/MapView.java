package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.board.prizes.EmptyPrize;
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
        cargarCoordenadas();
        initializeMap();

    }

    public void adjustSceneDimension() {
       
        double tileSize = 40.0; // Tamaño de cada imagen en el mapa

        double sceneWidth = mapWidth * tileSize;
        double sceneHeight = mapHeight * tileSize;

        this.getScene().getWindow().setWidth(sceneWidth);
        this.getScene().getWindow().setHeight(sceneHeight);
    }

    public void cargarCoordenadas(){
        walkableSquares.add(new PathSquare(new Coordinate(0,6),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(1,6),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(1,5),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(1,4),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(1,3),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(1,2),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(1,1),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(1,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(2,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(3,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(4,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(5,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(6,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(7,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(8,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(9,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(10,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,0),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,1),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,2),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,3),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,4),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,5),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,6),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,7),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(11,8),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(12,8),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(13,8),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(14,8),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(15,8),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,8),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,7),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,6),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,5),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,4),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,3),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,2),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,1),0,new EmptyPrize(), new EmptyObstacle()));
        walkableSquares.add(new PathSquare(new Coordinate(16,0),0,new EmptyPrize(), new EmptyObstacle()));
        /*
        */
    }
    private void initializeMap() {
 
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                ImageView tile = new ImageView(); 
                tile.setFitWidth(40);
                tile.setFitHeight(40);

                if (isAWalkableSquare(x, y)) {
                    
                    Image walkableImage = new Image("file:src/main/resources/images/rockTile.jpg");
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


    
