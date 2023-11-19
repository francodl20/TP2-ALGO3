package edu.fiuba.algo3.modelo;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Square;

public class CurrentPlayer {
    List<Gladiator> gladiators;
    ListIterator<Gladiator> turnManager;
    Integer turns;
    Board gameBoard;
    boolean gameFinished;
    Gladiator currentPlayer;
    public CurrentPlayer(List<Gladiator> listOfGladiators, Board board) {
        gladiators = listOfGladiators;
        turnManager = gladiators.listIterator();
        gameBoard = board;
        turns = 0;
        gameFinished = false;
        currentPlayer = null;
    }

    public CurrentPlayer(Integer amountOfPlayers, Board board) {
        gladiators = new LinkedList<Gladiator>();

        for (int i = 0; i < amountOfPlayers; i++) {
            gladiators.add(new Gladiator(new Novice(), 
                                        new Energy(), 
                                        new Position(), 
                                        new Helpless()));
        }
        turnManager = gladiators.listIterator();
        gameBoard = board;
        turns = 0;
        gameFinished = false;
        currentPlayer = null;
    }

    public void play() {
        if (gameFinished) return;
        if (turns >= 30) {
            finishGame(false);
            return;
        }
        if (! turnManager.hasNext() ) {
            turnManager = gladiators.listIterator();
            turns++;
        }
        currentPlayer = turnManager.next();
        if (currentPlayer.playTurn(Dice.roll())) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }
        if (gameBoard.finishCurrentPlay(currentPlayer) ) {
            finishGame(true);
        }
    }

    public void finishGame(boolean winners) {
        System.out.println("Game finished");
        System.out.println(winners?"...and this is the winner!":"...No winners! :(");
        gameFinished = true;
    }

    public Gladiator getCurrentPlayer() {
        return currentPlayer;
    }
}
