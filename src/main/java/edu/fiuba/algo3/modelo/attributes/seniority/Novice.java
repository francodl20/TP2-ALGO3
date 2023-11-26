package edu.fiuba.algo3.modelo.attributes.seniority;



public class Novice implements Seniority {
    int turns;

    public Novice() {
        turns = 0;
    }

    @Override
    public Seniority addTurn() {
        turns++;

        if (turns == 8) {
            return new SemiSenior();
        } else {
            return this;
        }
    }

    @Override
    public Integer energyPlus(Integer energy){
        return energy;
    }
}