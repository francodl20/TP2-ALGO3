package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;


public class BeastSquare implements ISquare {
    Position position;

    public BeastSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(IPlayer player) {
        player.fightAgainstWildBeast();
    }
    
    public boolean with(Position position){
        return this.position.equals(position);
    }
}