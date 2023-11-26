package edu.fiuba.algo3.modelo.attributes.seniority;



public class Senior implements Seniority {
    int turns;

    public Senior() {
        turns = 12;
    }

    @Override
    public Seniority addTurn() {
        turns++;
        return this;
    }

    @Override
    public Integer energyPlus(Integer energy) {
        
        return (energy + (10)); //CAMBIAR NUEMROS MAGICOS
    }
}