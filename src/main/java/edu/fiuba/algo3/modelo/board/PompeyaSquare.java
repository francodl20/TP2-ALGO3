package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;

public class PompeyaSquare implements ISquare {
    Position position;

    public PompeyaSquare(Position aPosition) {
        position = aPosition;
    }

    @Override
    public void play(IPlayer player) {
        player.arriveToPompeya();
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}