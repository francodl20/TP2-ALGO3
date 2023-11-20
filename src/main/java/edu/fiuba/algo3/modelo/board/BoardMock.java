package edu.fiuba.algo3.modelo.board;

import java.util.HashMap;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.Player;

public class BoardMock extends Board {
    HashMap<Position,Square> squareMap;

    public BoardMock() {
    }
    @Override
    public void playAtCurrentPositionWith(Player currentPlayer) {
        Position position = currentPlayer.getCurrentPosition();
        Square square;
        if (position.equals(new Position(0))) {
            square = new EmptySquare();
        }
        else if (position.compareTo(new Position(0)) > 0 && position.compareTo(new Position(5)) < 0) {
            square = new EquipmentSquare();
        }
        else if (position.compareTo(new Position(5)) >= 0 && position.compareTo(new Position(10)) < 0) {
            square = new BeastSquare();
        }
        else if (position.compareTo(new Position(10)) >= 0 && position.compareTo(new Position(15)) < 0) {
            square = new BacchanaliaSquare();
        }
        else if (position.compareTo(new Position(15)) >= 0 && position.compareTo(new Position(20)) < 0) {
            square = new FoodSquare();
        }
        else if (position.compareTo(new Position(20)) >= 0 && position.compareTo(new Position(25)) < 0) {
            square = new InjurySquare();
        }        
        else {
            square = new PompeyaSquare();
        }
        square.play(currentPlayer);
    }
}