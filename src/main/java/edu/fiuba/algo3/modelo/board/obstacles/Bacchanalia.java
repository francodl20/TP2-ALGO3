package edu.fiuba.algo3.modelo.board.obstacles;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;

public class Bacchanalia implements IObstacle {
    Position position;
        
    public Bacchanalia() { }

    public void harm(IPlayer player) {
        player.enjoyBacchanalia(4);
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}