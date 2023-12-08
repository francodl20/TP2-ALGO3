package edu.fiuba.algo3.modelo;

import java.util.Iterator;
import java.util.List;

public class TurnManager {
    List<Gladiator> players;
    Iterator<Gladiator> playersIterator;
    Gladiator currentPlayer;
    Integer turnCount;

    public TurnManager(List<Gladiator> gladiators) {
        this.players = gladiators;
        playersIterator = gladiators.iterator();
        currentPlayer = playersIterator.next();
        turnCount = 1;
    }

    public void pickRandomPlayer(Integer numberOfPlayer) {
        playersIterator = players.iterator();
        for (; numberOfPlayer > 1; numberOfPlayer--) {
            next();
        }
        turnCount = 0;
    }

    //Resets the iterator when it reaches the end
    public void next() {
        if (!playersIterator.hasNext()) {
            playersIterator = players.iterator();
        }
        currentPlayer = playersIterator.next();
    }

    //Use under discretion
    public Gladiator getCurrentGladiator(){
        return currentPlayer;
    }

    public Integer getTurnCount() {
        Integer gameTurn = turnCount / players.size();
        return gameTurn;
    }

    public Gladiator getNextGladiator(){
        Gladiator gladiator = currentPlayer;

        next();
        turnCount++;

        return gladiator;
    }
}
