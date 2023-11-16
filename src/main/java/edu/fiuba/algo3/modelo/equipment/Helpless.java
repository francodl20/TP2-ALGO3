package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.modelo.attributes.Energy;

public class Helpless implements Equipment {

    public Equipment enhance(){
        return new Helmet();
    }

    public Energy protectFromtWildBeast() {
        return new Energy(-20);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}