package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Gladiator;

public class EquipmentSquare implements Square {
    
    public EquipmentSquare() {
        
    }

    public void play(Gladiator gladiator) {
        gladiator.enhanceArmour();
        return;
    }
}