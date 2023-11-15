package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.Seniority;
import edu.fiuba.algo3.modelo.equipment.Equipment;

public class Gladiator {
    private Energy energy;
    private Seniority seniority;
    private Position position;
    private Equipment equipment;
    private int turns;

    public Gladiator(Seniority seniority, Energy energy, Position position, Equipment equipment) {
        this.energy = energy;
        this.seniority = seniority;
        this.position = position;
        this.equipment = equipment;
        this.turns = 0;
    }

    public void fightAgainstWildBeast() {
        this.energy = this.energy.add(this.equipment.protectFromtWildBeast());
    }

    public Energy getEnergy() {
        return energy;
    }

    public void eat(){

    }

    public void getInjured(){
        
    }

    public void enhanceArmour(){
        this.equipment.enhance();
    }

    public void enjoyBacchanalia(){

    }

}

