package edu.fiuba.algo3.modelo.attributes.seniority;


public interface ISeniority {

    //Add 1 to the turn counter, or change object if needed
    public ISeniority addTurn();

    //Return corresponding amount of energy
    public Integer energyPlus(Integer energy);
}