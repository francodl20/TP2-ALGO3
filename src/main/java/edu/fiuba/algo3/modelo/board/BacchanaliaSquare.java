package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Gladiator;

public class BacchanaliaSquare implements Square {
    
    public BacchanaliaSquare() {
        
    }

    public void play(Gladiator gladiator) {
        gladiator.enjoyBacchanalia();
        return;
    }
}