package edu.fiuba.algo3.modelo.attributes.seniority;
import edu.fiuba.algo3.modelo.attributes.Energy;

public interface Seniority {

    //Add 1 to the turn counter, or change object if needed
    public Seniority addTurn();

    //Return corresponding amount of energy
    public Energy energyPlus();
}