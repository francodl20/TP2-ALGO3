package edu.fiuba.algo3.modelo.attributes.seniority;

import edu.fiuba.algo3.modelo.attributes.Energy;

public class Senior implements Seniority {
    int turns;

    public Senior(){
        turns = 12;
    }

    @Override
    public Seniority addTurn(){
        turns++;
        return this;
    }

    @Override
    public Energy energyPlus(){
        return new Energy(10);
    }
}