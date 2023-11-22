package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.modelo.attributes.Energy;

public class Helmet implements Equipment {

    public Equipment enhance(){
        return new Armour();
    }

    public Energy protectFromtWildBeast() {
        return new Energy(-15);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}