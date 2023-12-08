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
    private Integer energy;
    private ISeniority seniority;
    private Integer position;
    private IEquipment equipment;
    private IPlayerState playerState;
    private String playerName;
    private Boolean lastTurnPlayed;
    private IDice dice;

    public Gladiator(String playerName, ISeniority seniority, Integer energy, Integer position, IEquipment equipment, IDice dice) {
        this.energy = energy;
        this.seniority = seniority;
        this.position = position;
        this.equipment = equipment;
        this.playerState = new Healthy(this);
        this.playerName = playerName;
        this.dice = dice;
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

    public void enjoyBacchanalia(Integer happyHourMultiplier){
        Integer diceRoll = dice.roll();
        /* todo tranqui?
            Un gladiador romano, con voz un poco temblorosa,
            canta una canción de amor en un bar lleno de locura.
            Se inclina hacia la mesa y toma otra copa.

            Este gladiador romano, con ojos rojos y sonrisa desordenada,
            canta una canción de amor en un bar lleno de locura.
            Se inclina hacia la mesa y toma otra copa.

            Su voz se vuelve más fuerte, pero también más desordenada,
            canta una canción de amor en un bar lleno de locura.
            Se inclina hacia la mesa y toma otra copa. 
            (La canción es "O Mio Babbino Caro" de Giacomo Puccini)
         */
        String gotDrankedSong = "Este gladiador romano, con ojos rojos y sonrisa desordenada,\n" +
                                "canta una canción de amor en un bar lleno de locura.\n" +
                                "Se inclina hacia la mesa y toma otra copa.\n";
                                //(La canción es "O Mio Babbino Caro" de Giacomo Puccini)
        Log.getInstance().info(gotDrankedSong);
        Log.getInstance().info("El gladiador parece que está borracho, se tomó " + diceRoll +  " tintos.");
        Integer energyLost = (happyHourMultiplier * diceRoll);
        Log.getInstance().info("... para recuperarse va a necesitar " + energyLost + " puntos de energía, ");
        this.energy = (this.energy - energyLost);
        Log.getInstance().info("... quedó con " + this.energy + " puntos.");
    }

    public void getInjured() {
        Log.getInstance().info("¿Por qué los malhumorados no juegan al escondite? Porque siempre los encuentran de mal humor.");
        Log.getInstance().info("El gladiador se tropezó con una piedra del camino... asique pierde el próximo turno :(");
        this.playerState.update();
    }

    public void fightAgainstWildBeast() {
        Log.getInstance().info("Que es esto? Es un pájaro? Es un avión? No... Es una bestia que quiere matar al gladiador!");
        Integer energyLost = this.equipment.protectFromtWildBeast();
        Log.getInstance().info("El gladiador está en un duro combate, intentó usar su equipamiento,\n");
        this.energy = this.energy + energyLost;
        Log.getInstance().info(" ahora su nuevo nivel de energía es: "+this.energy);

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

    //Setter
    public void moveFromCurrentPosition(Integer squaresToMove) {
        position = position + squaresToMove;
    }

    public void updateStateOfInjuries(IPlayerState newState) {
        this.playerState = newState;
    }
    //

    public void playTurn(IDice dice) {
        lastTurnPlayed = false;

        this.dice = dice;
        Integer diceRoll = dice.roll();

        this.energy = this.seniority.energyPlus(this.energy);
        if (this.energy > 0) {
            this.playerState.playTurn(diceRoll);
            lastTurnPlayed = this.playerState.turnPlayed();
            if (lastTurnPlayed) {
                Log.getInstance().info(getPlayerName() + " obtuvo: " + diceRoll + ", y avanzó hasta la casilla " + getCurrentPosition());
            } else {
                Log.getInstance().info(getPlayerName() + " se quedó descansando... sigue en la casilla " + getCurrentPosition());
            }
        } else {
            this.energy = this.energy + RECHARGE_RATE_PER_ROUND;
            Log.getInstance().info(getPlayerName() + " tiene noni... su energía es de: " + energy + ", por ahora sigue en la casilla " + getCurrentPosition());
        }
        this.seniority = this.seniority.addTurn();
    }

    

    
}





