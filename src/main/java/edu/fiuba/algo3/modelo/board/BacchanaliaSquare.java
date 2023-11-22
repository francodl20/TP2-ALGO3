package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;

public class BacchanaliaSquare implements Square {
    
    public BacchanaliaSquare() {
        
    }

    public void play(Player player) {
        player.enjoyBacchanalia(4);
        return;
    }
}