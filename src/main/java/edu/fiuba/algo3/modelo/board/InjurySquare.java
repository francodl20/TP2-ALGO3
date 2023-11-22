package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;


public class InjurySquare implements Square {
    
    public InjurySquare() {
        
    }

    public void play(Player player) {
        player.getInjured();
        return;
    }
}