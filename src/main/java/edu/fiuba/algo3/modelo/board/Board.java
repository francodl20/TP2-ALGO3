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

    public void playWith(Gladiator currentPlayer) {
        Integer controlVar = 0;

        for (ISquare square : map) {
            controlVar++;

            if(currentPlayer.in(square)){
                square.play(currentPlayer);

            } else if (controlVar > map.size()) {
                //In case the gladiator rolled more than the available squares
                currentPlayer.advance(map.size() - controlVar);
                map.getLast().play(currentPlayer);
            }
        }
    }

    public boolean pompeiiHas(Gladiator currentPlayer) {
        return (currentPlayer.in(map.getLast()));
    }
}