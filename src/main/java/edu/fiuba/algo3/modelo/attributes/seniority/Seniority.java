package edu.fiuba.algo3.modelo.attributes.seniority;


public interface Seniority {

    //Add 1 to the turn counter, or change object if needed
    public Seniority addTurn();

    //Return corresponding amount of energy
    public Integer energyPlus(Integer energy);
}