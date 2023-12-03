package edu.fiuba.algo3.modelo.board.obstacles;

import edu.fiuba.algo3.modelo.Gladiator;

public class Bacchanalia implements IObstacle {
        
    public Bacchanalia() { }

    public void harm(Gladiator player) {
        player.enjoyBacchanalia(4*diceRoll);
    }
}