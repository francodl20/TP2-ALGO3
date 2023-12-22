package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.OutputController;

public class Helpless implements IEquipment {

    public IEquipment enhance(){
        OutputController.enhancedNothing();
        return new Helmet();
    }

    public Integer protectFromtWildBeast() {
        return (-20);
    }

    public boolean canEnterPompeii() {
        return false;
    }
}