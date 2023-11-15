package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.Gladiator;

public class BeastSquare implements Square {
    
    public BeastSquare() {
        
    }

    public void play(Gladiator gladiator) {
        gladiator.fightAgainstWildBeast();
        return;
    }
}