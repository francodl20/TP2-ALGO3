package edu.fiuba.algo3.modelo;

import java.util.Iterator;
import java.util.List;

public class TurnManager {
    private List<Gladiator> players;
    private Iterator<Gladiator> playersIterator;
    private Gladiator currentPlayer;
    private Integer turnCount;

    public TurnManager(List<Gladiator> gladiators) {
        this.players = gladiators;
        playersIterator = gladiators.iterator();
        currentPlayer = playersIterator.next();
        turnCount = 1;
    }

    public void pickRandomPlayer(Integer diceRoll) {
        playersIterator = players.iterator();
        for (; diceRoll >= 1; diceRoll--) {
            next();
        }
    }

    //Resets the iterator when it reaches the end
    public void next() {
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

    public Integer getTurnCount() {
        Integer gameTurn = turnCount / players.size();
        return gameTurn;
    }
}
