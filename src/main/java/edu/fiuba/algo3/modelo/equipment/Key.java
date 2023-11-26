package edu.fiuba.algo3.modelo.equipment;

public class Key implements Equipment {

    public Equipment enhance(){
        return new Key();
    }

    public Integer protectFromtWildBeast() {
        return (0); 
    }

    public boolean arriveToPompeya() {
        return true;
    }
}