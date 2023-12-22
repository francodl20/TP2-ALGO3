package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.OutputController;

public class Armour implements IEquipment {

    public IEquipment enhance() {
        OutputController.enhancedArmour();
        return new SwordAndShield();
    }

    public Integer protectFromtWildBeast() {
        return -10;    
    }

    public boolean canEnterPompeii() {
        return false;
    }
}   