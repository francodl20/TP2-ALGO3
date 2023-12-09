package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.attributes.playerState.Healthy;
import edu.fiuba.algo3.modelo.attributes.playerState.IPlayerState;
import edu.fiuba.algo3.modelo.attributes.seniority.ISeniority;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.equipment.IEquipment;
import edu.fiuba.algo3.Log;

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
    public String getPlayerName() {
        return playerName;
    }

    public Integer getEnergy() {
        return this.energy;
    }

    public Integer getCurrentPosition(){
         return this.position;
    }

    public boolean turnPlayed() {
        return lastTurnPlayed;
    }
    //

    //Methods related to the squares
    public void eat(){
        this.energy = (this.energy + ENERGY_RECOVERED_AFTER_MEAL);
    }

    public void enhanceArmour(){
        this.equipment = this.equipment.enhance();
    }

    public void enjoyBacchanalia(Integer energyLost){
        String gotDrankedSong = "Este gladiador romano, con ojos rojos y sonrisa desordenada,\n" +
                                "canta una canción de amor en un bar lleno de locura.\n" +
                                "Se inclina hacia la mesa y toma otra copa.\n";
                                //(The song is called "O Mio Babbino Caro" by Giacomo Puccini)
        this.energy = (this.energy - energyLost);

        Log.getInstance().info(gotDrankedSong);
        Log.getInstance().info(
            "El gladiador parece que está borracho, se tomó " + energyLost/4 +  " tintos.");
        Log.getInstance().info(
            "... para recuperarse va a necesitar " + energyLost + " puntos de energía, ");
        Log.getInstance().info(
            "... quedó con " + this.energy + " puntos.");
    }

    public void getInjured() {
        Log.getInstance().info(
            "¿Por qué los malhumorados no juegan al escondite? Porque siempre los encuentran de mal humor.");
        Log.getInstance().info(
            "El gladiador se tropezó con una piedra del camino... así que pierde el próximo turno :(");
        this.playerState.update();
    }

    public void fightAgainstWildBeast() {
        Log.getInstance().info(
            "Que es esto? Es un pájaro? Es un avión? No... Es una bestia que quiere matar al gladiador!");
        Integer energyLost = this.equipment.protectFromtWildBeast();
        Log.getInstance().info(
            "El gladiador está en un duro combate, intentó usar su equipamiento,\n");
        this.energy = this.energy + energyLost;
        Log.getInstance().info(
            " ahora su nuevo nivel de energía es: " + this.energy);
    }

    public void arriveToPompeii() {
        if (!equipment.canEnterPompeii()) {
           position = position/2;
        }
    }

    public boolean in(ISquare square){
        return square.with(this.position);
    }
    //

    //Setters
    public void moveFromCurrentPosition(Integer squaresToMove) {
        position = position + squaresToMove;
    }

    public void updateStateOfInjuries(IPlayerState newState) {
        this.playerState = newState;
    }
    //

    public void playTurn(IDice dice) {
        lastTurnPlayed = false;

        this.energy = this.seniority.energyPlus(this.energy);

        Integer diceRoll = dice.roll();

        if (this.energy > 0) {
            this.playerState.playTurn(diceRoll);
            lastTurnPlayed = this.playerState.turnPlayed();
            
            if (lastTurnPlayed) {
                Log.getInstance().info(getPlayerName() + " obtuvo: " + 
                diceRoll + ", y avanzó hasta la casilla " + getCurrentPosition());
            } else {
                Log.getInstance().info(getPlayerName() + 
                " se quedó descansando... sigue en la casilla " + getCurrentPosition());
            }

        } else {
            this.energy = this.energy + RECHARGE_RATE_PER_ROUND;

            Log.getInstance().info(getPlayerName() + " tiene noni... su energía es de: " + 
            energy + ", por ahora sigue en la casilla " + getCurrentPosition());
        }

        this.seniority = this.seniority.addTurn();
    }
  
}





