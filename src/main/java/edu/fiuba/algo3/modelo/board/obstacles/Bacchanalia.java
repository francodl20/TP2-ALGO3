package edu.fiuba.algo3.modelo.board.obstacles;

import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.Gladiator;

public class Bacchanalia implements IObstacle {
    private final Integer ENERGY_DRAIN;

    public Bacchanalia() { 
    ENERGY_DRAIN = 4;
    }

    public void harm(Gladiator player) {
        D6 dice = new D6();
        player.enjoyBacchanalia(ENERGY_DRAIN * dice.roll());
    }

    public String getType(){
        return "Bachanalia";
    }
}