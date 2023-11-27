package edu.fiuba.algo3.modelo.board.obstacles;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;


public class Beast implements IObstacle {
    Position position;

    public Beast() { }

    public void harm(IPlayer player) {
        player.fightAgainstWildBeast();
    }
    
    public boolean with(Position position){
        return this.position.equals(position);
    }
}