package edu.fiuba.algo3.modelo.equipment;


public class SwordAndShield implements Equipment {

    public Equipment enhance(){
        return new Key();
    }

    public Integer protectFromtWildBeast() {
        return (-2);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}