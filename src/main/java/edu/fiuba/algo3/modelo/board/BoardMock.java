package edu.fiuba.algo3.modelo.board;

import java.util.HashMap;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.IPlayer;

public class BoardMock extends Board {
    HashMap<Position,ISquare> squareMap;

    public BoardMock() {
    }
    @Override
    public void playAtCurrentPositionWith(IPlayer currentPlayer) {
        Position position = currentPlayer.getCurrentPosition();
        ISquare square;
        if (position.equals(new Position(0))) {
            square = new EmptySquare(position);
        }
        else if (position.compareTo(new Position(0)) > 0 && position.compareTo(new Position(5)) < 0) {
            square = new EquipmentSquare(position);
        }
        else if (position.compareTo(new Position(5)) >= 0 && position.compareTo(new Position(10)) < 0) {
            square = new BeastSquare(position);
        }
        else if (position.compareTo(new Position(10)) >= 0 && position.compareTo(new Position(15)) < 0) {
            square = new BacchanaliaSquare(position);
        }
        else if (position.compareTo(new Position(15)) >= 0 && position.compareTo(new Position(20)) < 0) {
            square = new FoodSquare(position);
        }
        else if (position.compareTo(new Position(20)) >= 0 && position.compareTo(new Position(25)) < 0) {
            square = new InjurySquare(position);
        }        
        else {
            square = new PompeyaSquare(position);
        }
        square.play(currentPlayer);
    }
}