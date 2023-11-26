package edu.fiuba.algo3.modelo.equipment;


public class Helpless implements Equipment {

    public Equipment enhance(){
        return new Helmet();
    }

    public Integer protectFromtWildBeast() {
        return (-20);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}