package edu.fiuba.algo3.modelo.attributes.seniority;



public class Senior implements ISeniority {
    Integer turns;
    Integer SENIORITY_BONUS = 10;
    Integer SENIORITY_THRESHOLD = 12;
    //todo crear clase de constantes de juego "GameConstants"
    public Senior() {
        turns = SENIORITY_THRESHOLD;
    }

    @Override
    public ISeniority addTurn() {
        turns++;
        return this;
    }

    @Override
    public Integer energyPlus(Integer energy) {
        
        return (energy + SENIORITY_BONUS);
    }
}