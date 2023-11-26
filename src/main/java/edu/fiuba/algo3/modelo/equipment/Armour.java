package edu.fiuba.algo3.modelo.equipment;

public class Armour implements Equipment {

    public Equipment enhance() {
        return new SwordAndShield();
    }

    public Integer protectFromtWildBeast() {
        return -10;    
    }

    public boolean arriveToPompeya() {
        return false;
    }
}   