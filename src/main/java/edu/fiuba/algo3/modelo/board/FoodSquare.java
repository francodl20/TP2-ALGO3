package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;

public class FoodSquare implements Square {
    
    public FoodSquare() {
        
    }

    public void play(Player player) {
        player.eat();
    }
}