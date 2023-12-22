package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.OutputController;

public class Helmet implements IEquipment {

    public IEquipment enhance(){
        OutputController.enhancedHelmet();
        return new Armour();
    }

    public Integer protectFromtWildBeast() {
        return (-15);
    }

    public boolean canEnterPompeii() {
        return false;
    }
}