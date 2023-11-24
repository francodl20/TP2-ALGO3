package edu.fiuba.algo3.modelo.attributes.seniority;

import edu.fiuba.algo3.modelo.attributes.Energy;

public class SemiSenior implements Seniority {
    int turns;

    public SemiSenior(){
        turns = 8;
    }

    @Override
    public Seniority addTurn(){
        turns++;

        if (turns == 12) {
            return new Senior();
        } else {
            return this;
        }
    }

    @Override
    public Energy energyPlus(Energy energy){
        return energy.add(new Energy(5));
    }
}