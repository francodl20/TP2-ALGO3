package edu.fiuba.algo3.modelo;

import java.util.Iterator;
import java.util.List;

public class TurnManager {
    private List<Gladiator> players;
    private Iterator<Gladiator> playersIterator;
    private Gladiator currentPlayer;
    private Integer turnCount;
/*
 
public TurnManager(List<Gladiator> gladiators) {
    this.players = gladiators;
        playersIterator = gladiators.iterator();
        currentPlayer = playersIterator.next();
        turnCount = 1;
    }
    
    */
    public TurnManager(List<Gladiator> gladiators) {
        this.players = gladiators;
        playersIterator = gladiators.iterator();
       initializeStartingPlayer();
        turnCount = 1;
    }

    private void initializeStartingPlayer() {
       
        Integer firstPlayerIndex = pickPlayerWithHighestRoll();

        
        for (int i = 0; i < firstPlayerIndex; i++) {
            next();
        }

        currentPlayer = playersIterator.next();
    }
    
    public void pickRandomPlayer(Integer diceRoll) {
        playersIterator = players.iterator();
        for (; diceRoll >= 1; diceRoll--) {
            next();
        }
    }



    public Integer pickPlayerWithHighestRoll() {
        IDice dice = new D6();
        Integer gladiator = 0;
        Integer maxDiceNumber = 0;
        for (Integer i = 0; i < players.size(); i++) {
            int currentDiceNumber = dice.roll();
            if (currentDiceNumber > maxDiceNumber) {
                maxDiceNumber = currentDiceNumber;
                gladiator = i;
            }
        }

        return gladiator;
    }

    //Resets the iterator when it reaches the end
    private void next() {
        if (!playersIterator.hasNext()) {
            playersIterator = players.iterator();
        }
        currentPlayer = playersIterator.next();
    }

    //Getters
    public Gladiator getNextGladiator(){
        Gladiator gladiator = currentPlayer;

        next();
        turnCount++;

        return gladiator;
    }

    //Use under discretion
    public Gladiator getCurrentGladiator(){
        return currentPlayer;
    }

    //Use under discretion
    public List<Gladiator> getGladiators(){
        return players;
    }

    public Integer getTurnCount() {
        Integer gameTurn = turnCount / players.size();
        return gameTurn;
    }
}
