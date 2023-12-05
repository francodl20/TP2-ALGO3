package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.board.squares.ISquare;
//Ext libraries
import java.util.*;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MapView extends GridPane{


    private Integer mapWidth;
    private Integer mapHeight;
    private LinkedList<ISquare> walkableSquares;

    public MapView(Integer mapWidth, Integer mapHeight, LinkedList<ISquare> walkableSquares) {
        if (mapWidth <= 0 || mapHeight <= 0) {
            throw new IllegalArgumentException("Dimensiones del mapa deben ser mayores que cero");
        }

        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.walkableSquares = walkableSquares;

        initializeMap();
    }

    private void initializeMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                Rectangle tile = new Rectangle(30, 30);
                tile.setStroke(Color.BLACK);

                if (isAWalkableSquare(x, y)) {
                    tile.setFill(Color.WHITE);
                } else {
                    tile.setFill(Color.BLACK);
                }

                this.add(tile, x, y);
            }
        }
    }

    private boolean isAWalkableSquare(int x, int y) {
       
        boolean isWalkableSquare = false;           //Feo feo, ver si se puede usar contains o algo asi
        for (ISquare square : walkableSquares) {
            if ((square.getSquareCoordinate().getXValue() == x) && (square.getSquareCoordinate().getYValue() == y)) {
                isWalkableSquare = true;
            }
        }
       return isWalkableSquare;
    }
}


    
