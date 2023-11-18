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
    public CurrentPlayer() {
        gladiators = new LinkedList<Gladiator>();
        turnManager = gladiators.listIterator();
        turns = 0;
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
    }

    public void play() {
        if (turns >= 30) {
            finishGame();
        }
        if (! turnManager.hasNext() ) {
            turnManager = gladiators.listIterator();
            turns++;
        }
        Gladiator currentPlayer = turnManager.next();
        if (currentPlayer.playTurn(Dice.roll())) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }
    }

    public void finishGame() {

    }


}
