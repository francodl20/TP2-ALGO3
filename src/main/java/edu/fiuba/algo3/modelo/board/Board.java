package edu.fiuba.algo3.modelo.board;

import java.util.HashMap;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.Player;

public class Board {
    HashMap<Position,Square> squareMap;

    public Board() {
        squareMap = new HashMap<>();
    }
    public void playAtCurrentPositionWith(Player currentPlayer) {
        Square currentSquare = squareMap.get(currentPlayer.getCurrentPosition());
        currentSquare.play(currentPlayer);
    }

    public boolean pompeyaWasReached(Player currentPlayer) {
        Position currentPosition = currentPlayer.getCurrentPosition();
        return (currentPosition == new Position(25));
    }

    /*
    private Position getPompeya() {
        //:)
    }
    */

}