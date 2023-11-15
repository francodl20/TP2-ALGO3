package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.Gladiator;

public class InjurySquare implements Square {
    
    public InjurySquare() {
        
    }

    public void play(Gladiator gladiator) {
        gladiator.getInjured();
        return;
    }
}