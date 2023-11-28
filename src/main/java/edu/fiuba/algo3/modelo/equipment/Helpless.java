package edu.fiuba.algo3.modelo.equipment;


public class Helpless implements IEquipment {

    public IEquipment enhance(){
        return new Helmet();
    }

    public Integer protectFromtWildBeast() {
        return (-20);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}