package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.modelo.attributes.Energy;
public class Key implements Equipment {

    public Equipment enhance(){
        return new Key();
    }

    public Energy protectFromtWildBeast() {
        return  new Energy(0); 
    }

    public boolean arriveToPompeya() {
        return true;
    }
}