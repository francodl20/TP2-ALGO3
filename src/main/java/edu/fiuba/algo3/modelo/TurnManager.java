package edu.fiuba.algo3.modelo;

import java.util.Iterator;
import java.util.List;

public class TurnManager {

    List<Gladiator> players;
    Iterator<Gladiator> playersIter;

    Gladiator currentPlayer;

    Integer turnCount;
    public TurnManager(List<Gladiator> gladiators) {
        this.players = gladiators;
    }
    Gladiator getCurrent() {
        return currentPlayer;
    }
    //Resets the iterator when it reaches the end
    public void next() {
        if (!playersIter.hasNext()) {
            playersIter = players.iterator();
            turnCount++;
        }
        currentPlayer = playersIter.next();
    }
    public void pickRandomPlayer(Integer numberOfPlayer) {
        playersIter = players.iterator();
        for (; numberOfPlayer > 1; numberOfPlayer--) {
            next();
        }
        turnCount = 0;
    }
    public Integer getTurnCount() {
        return turnCount;
    }
}
