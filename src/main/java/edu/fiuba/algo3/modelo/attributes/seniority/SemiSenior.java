package edu.fiuba.algo3.modelo.attributes.seniority;



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
    public Integer energyPlus(Integer energy){
        return (energy + (5)); //CAMBIAR NUMEROS MAGICOS
    }
}