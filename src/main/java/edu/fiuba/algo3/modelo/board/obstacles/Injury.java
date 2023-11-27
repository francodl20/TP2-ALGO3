package edu.fiuba.algo3.modelo.board.obstacles;
import edu.fiuba.algo3.modelo.IPlayer;

public class Injury implements IObstacle {

    public void harm(IPlayer player) {
        player.getInjured();
    }

}