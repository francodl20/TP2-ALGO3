package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;


public class InjurySquare implements Square {
    Position position;

    public InjurySquare(Position aPosition) {
        position = aPosition;
    }

    public void play(Player player) {
        player.getInjured();
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}