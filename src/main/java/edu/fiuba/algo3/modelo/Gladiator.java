package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.Square;
import edu.fiuba.algo3.modelo.attributes.InjuredState.Healthy;
import edu.fiuba.algo3.modelo.attributes.InjuredState.InjuredState;
import edu.fiuba.algo3.modelo.attributes.seniority.Seniority;
import edu.fiuba.algo3.modelo.equipment.Equipment;

public class Gladiator implements Player {
    private final Integer ENERGY_RECOVERED_AFTER_MEAL = 10;
    private final Integer TURN_ENERGY_COST = -1;
    private final Integer ENERGY_LOST_PER_ALCOHOLIC_DRINK = -4;
    private Energy energy;
    private Seniority seniority;
    private Position position;
    private Equipment equipment;
    private InjuredState injuries;
    //private int turns;
    
    public Gladiator(Seniority seniority, Energy energy, Position position, Equipment equipment) {
        this.energy = energy;
        this.seniority = seniority;
        this.position = position;
        this.equipment = equipment;
        this.injuries = new Healthy(this);
        // this.turns = 0;
    }


    //Methods related to the squares
        public void eat(){
            this.energy = this.energy.add(new Energy(ENERGY_RECOVERED_AFTER_MEAL));
        }

        public void enhanceArmour(){
            this.equipment = this.equipment.enhance();
        }

        public void enjoyBacchanalia(Integer howManyDrinks){
            this.energy = this.energy.add(new Energy(howManyDrinks*ENERGY_LOST_PER_ALCOHOLIC_DRINK);
        }

        public void getInjured() {
            // this.energy.getInjured();
            this.injuries.update();
        }

        public void fightAgainstWildBeast() {
            this.energy = this.energy.add(this.equipment.protectFromtWildBeast());
        }

        public void arriveToPompeya() {
            if (!equipment.arriveToPompeya()) {
                position = new Position(position.getCurrentPosition()/2);
            }
        }
    //

    public Energy getEnergy() {
        return energy;
    }

    public Position getCurrentPosition(){
         return this.position;
    }

    public Position moveFromCurrentPosition(Position howManySquaresToMove) {
        position = position.add(howManySquaresToMove);
        return position;
    }

    public boolean playTurn(Integer squaresToMove){
        this.energy = this.seniority.energyPlus(this.energy);
        // costo de jugar el turno
        this.energy = this.energy.add(new Energy(TURN_ENERGY_COST));
        if (!energy.isEmpty()) {
            this.injuries.playTurn(squaresToMove);
        } else {
            this.energy.add(new Energy(5));
        }
        this.seniority = this.seniority.addTurn();

        return true;
    }

    public void updateInjuries(InjuredState newState) {
        this.injuries = newState;
    }

    public boolean in(Square square){
        return square.with(this.position);
    }
}





