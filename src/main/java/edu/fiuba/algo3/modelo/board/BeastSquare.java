package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;


public class BeastSquare implements Square {
    Position position;

    public BeastSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(Player player) {
        player.fightAgainstWildBeast();
        return;
    }
    
    public boolean with(Position position){
        return this.position.equals(position);
    }
}