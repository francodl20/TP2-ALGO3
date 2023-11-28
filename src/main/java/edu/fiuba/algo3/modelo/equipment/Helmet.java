package edu.fiuba.algo3.modelo.equipment;

public class Helmet implements IEquipment {

    public IEquipment enhance(){
        return new Armour();
    }

    public Integer protectFromtWildBeast() {
        return (-15);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}