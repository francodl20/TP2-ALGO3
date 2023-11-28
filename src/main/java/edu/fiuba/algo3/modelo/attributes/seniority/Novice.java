package edu.fiuba.algo3.modelo.attributes.seniority;



public class Novice implements ISeniority {
    Integer turns;
    Integer SEMISENIORITY_THRESHOLD = 8;
    Integer NOVICE_THRESHOLD = 0;
    Integer NOVICE_BONUS = 0;

    //todo crear clase de constantes de juego "GameConstants"

    public Novice() {
        turns = NOVICE_THRESHOLD;
    }

    @Override
    public ISeniority addTurn() {
        turns++;

        if (turns.equals(SEMISENIORITY_THRESHOLD)) {
            return new SemiSenior();
        } else {
            return this;
        }
    }

    @Override
    public Integer energyPlus(Integer energy){
        return energy + NOVICE_BONUS;
    }
}