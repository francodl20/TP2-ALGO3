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
        squareMap.get(currentPlayer.getCurrentPosition()).play(currentPlayer);
    }

    public boolean finishCurrentPlay(Player currentPlayer) {
        return false;
    }
}