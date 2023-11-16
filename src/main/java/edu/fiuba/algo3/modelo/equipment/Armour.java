package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.modelo.attributes.Energy;

//import edu.fiuba.algo3.modelo.attributes.Energy;

public class Armour implements Equipment {

    public Equipment enhance() {
        return new SwordAndShield();
    }

    public Energy protectFromtWildBeast() {
        return new Energy(-10);    
    }

    public boolean arriveToPompeya() {
        return false;
    }
}   