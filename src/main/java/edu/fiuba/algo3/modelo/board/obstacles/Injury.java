package edu.fiuba.algo3.modelo.board.obstacles;
import edu.fiuba.algo3.modelo.Gladiator;

public class Injury implements IObstacle {

    public void harm(Gladiator player) {
        player.getInjured();
    }
}