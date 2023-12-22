package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.attributes.playerState.IPlayerState;
import edu.fiuba.algo3.modelo.attributes.seniority.ISeniority;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.equipment.IEquipment;

import edu.fiuba.algo3.modelo.attributes.playerState.Healthy;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.OutputController;

public class Gladiator {
    private final Integer ENERGY_RECOVERED_AFTER_MEAL = 15;
    private final Integer RECHARGE_RATE_PER_ROUND = 5;
    private ISeniority seniority;
    private String playerName;
    private Integer position;
    private Integer energy;
    private IPlayerState playerState;
    private IEquipment equipment;
    private Boolean lastTurnPlayed;

    public Gladiator(String playerName) {
        this.seniority = new Novice();
        this.playerName = playerName;
        this.position = 1;
        this.energy = 20;
        this.playerState = new Healthy(this);
        this.equipment = new Helpless();
        this.lastTurnPlayed = false;
    }

    public Gladiator(String playerName, ISeniority seniority, Integer energy, Integer position, IEquipment equipment) {
        this.seniority = seniority;
        this.playerName = playerName;
        this.position = position;
        this.energy = energy;
        this.playerState = new Healthy(this);
        this.equipment = equipment;
        this.lastTurnPlayed = false;
    }

    //Getters
    public String getName() {
        return playerName;
    }

    public Integer getEnergy() {
        return this.energy;
    }

    public Integer getPosition(){
         return this.position;
    }

    public boolean turnPlayed() {
        return lastTurnPlayed;
    }
    //

    //Methods related to the squares
    public void eat(){
        this.energy = (this.energy + ENERGY_RECOVERED_AFTER_MEAL);
        OutputController.ateFood(getName(), getEnergy());

    }

    public void enhanceArmour(){
        this.equipment = this.equipment.enhance();
    }

    public void enjoyBacchanalia(Integer energyLost){
        this.energy = (this.energy - energyLost);
        OutputController.partied(energyLost, getEnergy());
    }

    public void getInjured() {
        this.playerState = this.playerState.update();
        OutputController.gotInjured();
    }

    public void fightAgainstWildBeast() {
        Integer energyLost = this.equipment.protectFromtWildBeast();
        this.energy = this.energy + energyLost;

        OutputController.foughtWithABeast(getEnergy());
    }

    public void arriveToPompeii() {
        if (!equipment.canEnterPompeii()) {
           position = position/2;
           
           OutputController.notReachedPompeii();
        }

        OutputController.reachedPompeii(getName());
    }

    public boolean in(ISquare square){
        return square.with(this.position);
    }
    //

    //Setters
    public void advance(Integer squaresToMove) {
        position = position + squaresToMove;
    }

    public void updateStateOfInjuries(IPlayerState newState) {
        this.playerState = newState;
    }
    //

    public Integer playTurn(IDice dice) {
        lastTurnPlayed = false;

        this.energy = this.seniority.energyPlus(this.energy);

        Integer diceRoll = dice.roll();

        if (this.energy > 0) {
            this.playerState = this.playerState.playTurn(diceRoll);
            lastTurnPlayed = this.playerState.turnPlayed();
            
            if (lastTurnPlayed) {
                OutputController.playerPlayed(getName(), diceRoll, getEnergy());
            } else {
                OutputController.playerNotPlayed(getName(), getEnergy());
            }

        } else {
            this.energy = this.energy + RECHARGE_RATE_PER_ROUND;
            OutputController.playerOutOfEnergy(getName(), getEnergy());
            
        }

        this.seniority = this.seniority.addTurn();
        
        OutputController.actualPosition(position);

        return diceRoll;
    }
    
    public void stayInBound(Integer lastPosition){
        this.position = lastPosition;
    }
}





