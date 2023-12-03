package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.attributes.playerState.Healthy;
import edu.fiuba.algo3.modelo.attributes.playerState.IPlayerState;
import edu.fiuba.algo3.modelo.attributes.seniority.ISeniority;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.equipment.IEquipment;
import edu.fiuba.algo3.Log;

public class Gladiator {
    private final Integer ENERGY_RECOVERED_AFTER_MEAL = 15;
    private final Integer ENERGY_LOST_PER_ALCOHOLIC_DRINK = -4;
    private final Integer RECHARGE_RATE_PER_ROUND = 5;
    private Integer energy;
    private ISeniority seniority;
    private Integer position;
    private IEquipment equipment;
    private IPlayerState playerState;
    private String playerName;
    private Boolean lastTurnPlayed;
    private IDice dice;
    
    public Gladiator(String playerName, ISeniority seniority, Integer energy, Integer position, IEquipment equipment, IDice playerDice) {
        this.energy = energy;
        this.seniority = seniority;
        this.position = position;
        this.equipment = equipment;
        this.playerState = new Healthy(this);
        this.playerName = playerName;
        this.dice = playerDice;
    }

    public String getPlayerName() {
        return playerName;
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
        this.playerState.update();
    }

    public void fightAgainstWildBeast() {
        Integer energyLost = this.equipment.protectFromtWildBeast();
        this.energy = this.energy + energyLost;
    }

    public void arriveToPompeya() {
        if (!equipment.arriveToPompeya()) {
           position = position/2;
        }
    }

    public boolean in(ISquare square){
        return square.with(this.position);
    }
    //

    public Integer getEnergy() {
        return this.energy;
    }

    public Integer getCurrentPosition(){
         return this.position;
    }

    public void moveFromCurrentPosition(Integer howManySquaresToMove) {
        position = position + howManySquaresToMove;
    }

    public void playTurn(IDice dice) {
        lastTurnPlayed = false;
        Integer diceRoll = dice.roll();

        this.energy = this.seniority.energyPlus(this.energy);
        if (this.energy > 0) {
            Log.getInstance().info(getPlayerName()+" obtuvo: "+diceRoll+", ");
            this.playerState.playTurn(diceRoll);
            lastTurnPlayed = this.playerState.turnPlayed();
            if (lastTurnPlayed) {
                Log.getInstance().info(getPlayerName()+"obtuvo: "+diceRoll+", y avanzó hasta la casilla "+getCurrentPosition());
            } else {
                Log.getInstance().info(getPlayerName()+"se quedó descansando... sigue en la casilla "+getCurrentPosition());
            }
        } else {
            this.energy = this.energy + RECHARGE_RATE_PER_ROUND;
            Log.getInstance().info(getPlayerName()+"tiene noni... su energía es de: "+energy+", por ahora sigue en la casilla "+getCurrentPosition());
        }
        this.seniority = this.seniority.addTurn();
    }

    public boolean turnPlayed() {
        return lastTurnPlayed;
    }

    public void updateStateOfInjuries(IPlayerState newState) {
        this.playerState = newState;
    }

    
}





