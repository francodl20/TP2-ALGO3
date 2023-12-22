package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.OutputController;

public class SwordAndShield implements IEquipment {

    public IEquipment enhance(){
        OutputController.enhancedSwordAndShield();
        return new Key();
    }

    public Integer protectFromtWildBeast() {
        return (-2);
    }

    public boolean canEnterPompeii() {
        return false;
    }
}