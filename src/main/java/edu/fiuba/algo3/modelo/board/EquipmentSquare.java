package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;

public class EquipmentSquare implements Square {
    
    public EquipmentSquare() {
        
    }

    public void play(Player player) {
        player.enhanceArmour();
        return;
    }
}