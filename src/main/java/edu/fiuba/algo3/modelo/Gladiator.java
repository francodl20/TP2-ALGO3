package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.playerState.Healthy;
import edu.fiuba.algo3.modelo.attributes.playerState.IPlayerState;
import edu.fiuba.algo3.modelo.attributes.seniority.ISeniority;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.equipment.IEquipment;

public class Gladiator implements IPlayer {
    private final Integer ENERGY_RECOVERED_AFTER_MEAL = 15;
    private final Integer ENERGY_LOST_PER_ALCOHOLIC_DRINK = -4;
    private final Integer RECHARGE_RATE_PER_ROUND = 5;
    private Integer energy;
    private ISeniority seniority;
    private Position position;
    private IEquipment equipment;
    private IPlayerState playerState;
    //private int turns;
    
    public Gladiator(ISeniority seniority, Integer energy, Position position, IEquipment equipment) {
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
        Integer energyLost = this.equipment.protectFromtWildBeast();
        this.energy = this.energy + energyLost;
        //gamestate.beastSquare(energyLost)
    }

    public void arriveToPompeya() {
        if (!equipment.arriveToPompeya()) {
            position = new Position(position.getCurrentPosition()/2);
        }
    }

    public boolean in(ISquare square){
        return square.with(this.position);
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

    public boolean playTurn(IDice dice){
        boolean played = false;
        Integer diceRoll = dice.roll();

        this.energy = this.seniority.energyPlus(this.energy);
        if (this.energy > 0) {
            played = this.playerState.playTurn(diceRoll);
        } else {
            this.energy = this.energy + RECHARGE_RATE_PER_ROUND;
            // El jugador pepito esta cansao, le damos 5 y que siga esperando a la siguiente ronda.
        }
        this.seniority = this.seniority.addTurn();

        return played;
    }

    public void updateStateOfInjuries(IPlayerState newState) {
        this.playerState = newState;
    }

    
}





