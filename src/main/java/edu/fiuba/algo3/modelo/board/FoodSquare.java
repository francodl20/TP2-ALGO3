package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Gladiator;

public class FoodSquare implements Square {
    
    public FoodSquare() {
        
    }

    public void play(Gladiator gladiator) {
        gladiator.eat();
    }
}