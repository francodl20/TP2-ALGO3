package edu.fiuba.algo3.modelo.board.obstacles;

import edu.fiuba.algo3.modelo.Gladiator;

public class Bacchanalia implements IObstacle {
    private final Integer ENERGY_DRAIN;

    public Bacchanalia() { 
    ENERGY_DRAIN = 4;
    }

    public void harm(Gladiator player) {
        player.enjoyBacchanalia(ENERGY_DRAIN);
    }
}