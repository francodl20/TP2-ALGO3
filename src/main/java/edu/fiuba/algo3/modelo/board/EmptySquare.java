package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;

public class EmptySquare implements Square {
    Position position;

    public EmptySquare(Position aPosition) {
        position = aPosition;
    }
    public void play(Player player) {
        return;
    }
    public boolean with(Position position){
        return this.position.equals(position);
    }
}