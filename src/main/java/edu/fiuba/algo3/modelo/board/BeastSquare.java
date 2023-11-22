package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;


public class BeastSquare implements Square {
    
    public BeastSquare() {
        
    }

    public void play(Player player) {
        player.fightAgainstWildBeast();
        return;
    }
}