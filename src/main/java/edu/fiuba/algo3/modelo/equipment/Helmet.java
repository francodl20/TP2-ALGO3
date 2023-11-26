package edu.fiuba.algo3.modelo.equipment;

public class Helmet implements Equipment {

    public Equipment enhance(){
        return new Armour();
    }

    public Integer protectFromtWildBeast() {
        return (-15);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}