package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.OutputController;

public class Key implements IEquipment {

    public IEquipment enhance(){
        OutputController.enhancedKey();
        return new Key();
    }

    public Integer protectFromtWildBeast() {
        return (0); 
    }

    public boolean canEnterPompeii() {
        return true;
    }
}