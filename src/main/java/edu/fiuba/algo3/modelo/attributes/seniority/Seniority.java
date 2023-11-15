package edu.fiuba.algo3.modelo.attributes.seniority;
import edu.fiuba.algo3.modelo.attributes.Energy;

public interface Seniority {
    public Seniority addTurn();
    public Energy energyPlus();
}