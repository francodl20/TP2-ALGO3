package edu.fiuba.algo3.modelo.board;

//Local clases
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.Gladiator;

import java.util.*;

public class Board {
   
    LinkedList<ISquare> map;
    Coordinate dimension;

    public Board(String jsonFilePath) throws Exception {
        map = Parser.buildFromJson(jsonFilePath);
    }

    public void playAtCurrentPositionWith(Gladiator currentPlayer) {
        for (ISquare square : map) {
            if(currentPlayer.in(square)){
                square.play(currentPlayer);
            }
        }
    }

    public boolean pompeiiHas(Gladiator currentPlayer) {
        return (currentPlayer.in(map.getLast()));
    }
}