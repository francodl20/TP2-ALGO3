package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.Square;
import edu.fiuba.algo3.modelo.attributes.playerState.Healthy;
import edu.fiuba.algo3.modelo.attributes.playerState.PlayerState;
import edu.fiuba.algo3.modelo.attributes.seniority.Seniority;
import edu.fiuba.algo3.modelo.equipment.Equipment;

public class Gladiator implements Player {
    private final Integer ENERGY_RECOVERED_AFTER_MEAL = 10;
    private final Integer ENERGY_LOST_PER_ALCOHOLIC_DRINK = -4;

    private final Integer RECHARGE_RATE_PER_ROUND = 5;
    private Integer energy;
    private Seniority seniority;
    private Position position;
    private Equipment equipment;
    private PlayerState playerState;
    //private int turns;
    
    public Gladiator(Seniority seniority, Integer energy, Position position, Equipment equipment) {
        this.energy = energy;
        this.seniority = seniority;
        this.position = position;
        this.equipment = equipment;
        this.playerState = new Healthy(this);
        // this.turns = 0;
    }


    //Methods related to the squares
        public void eat(){
            this.energy = (this.energy + ENERGY_RECOVERED_AFTER_MEAL);
        }

        public void enhanceArmour(){
            this.equipment = this.equipment.enhance();
        }

        public void enjoyBacchanalia(Integer howManyDrinks){
            this.energy = (this.energy + (howManyDrinks * ENERGY_LOST_PER_ALCOHOLIC_DRINK));
        }

        public void getInjured() {
            // this.energy.getInjured();
            this.playerState.update();
        }

        public void fightAgainstWildBeast() {

            this.energy = this.energy + this.equipment.protectFromtWildBeast();
        }

        public void arriveToPompeya() {
            if (!equipment.arriveToPompeya()) {
                position = new Position(position.getCurrentPosition()/2);
            }
        }
    //

    public Integer getEnergy() {
        return this.energy;
    }

    public Position getCurrentPosition(){
         return this.position;
    }

    public void moveFromCurrentPosition(Position howManySquaresToMove) {
        position = position.add(howManySquaresToMove);
    }

    public boolean playTurn(Integer squaresToMove){
        boolean played = false;
        this.energy = this.seniority.energyPlus(this.energy);
        if (this.energy > 0) {
            played = this.playerState.playTurn(squaresToMove);
        } else {
            this.energy = this.energy + RECHARGE_RATE_PER_ROUND;
        }
        this.seniority = this.seniority.addTurn();

        return played;
    }

    public void updateStateOfInjuries(PlayerState newState) {
        this.playerState = newState;
    }

    public boolean in(Square square){
        return square.with(this.position);
    }
}





