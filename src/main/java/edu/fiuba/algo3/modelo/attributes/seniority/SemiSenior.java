package edu.fiuba.algo3.modelo.attributes.seniority;



public class SemiSenior implements Seniority {
    Integer turns;
    Integer SEMISENIORITY_BONUS = 5;
    Integer SENIORITY_THRESHOLD = 12;
    Integer SEMISENIORITY_THRESHOLD = 8;

    //todo crear clase de constantes de juego "GameConstants"
    public SemiSenior(){
        turns = SEMISENIORITY_THRESHOLD;
    }

    @Override
    public Seniority addTurn(){
        turns++;

        if (turns.equals(SENIORITY_THRESHOLD)) {
            return new Senior();
        } else {
            return this;
        }
    }

    @Override
    public Integer energyPlus(Integer energy){
        return (energy + SEMISENIORITY_BONUS);
    }
}