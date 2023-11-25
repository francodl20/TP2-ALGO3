package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;

public class PompeyaSquare implements Square {
    Position position;

    public PompeyaSquare(Position aPosition) {
        position = aPosition;
    }

    @Override
    public void play(Player player) {
        player.arriveToPompeya();
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}