package edu.fiuba.algo3.modelo;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.Gladiator;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Square;

public class TurnManager {
    public static final Integer MAX_ROUNDS = 30;
    List<Gladiator> gladiators;
    ListIterator<Gladiator> turnManager;
    Gladiator currentPlayer;
    Integer turnCount;
    Board gameBoard;
    
    
    public TurnManager(List<Gladiator> listOfGladiators, Board board) {
        gladiators = listOfGladiators;
        turnManager = gladiators.listIterator();
        gameBoard = board;
        turnCount = 1;
        currentPlayer = null;
    }

    public TurnManager(Integer amountOfPlayers, Board board) {
        gladiators = new LinkedList<Gladiator>();
        Integer initialEnergy = 20;  //REVISAR ENERGIA INICIAL

        for (int i = 0; i < amountOfPlayers; i++) {
            gladiators.add(new Gladiator(new Novice(), 
                                        initialEnergy, 
                                        new Position(), 
                                        new Helpless()));
        }
        turnManager = gladiators.listIterator();
        gameBoard = board;
        turnCount = 1;
        currentPlayer = null;
    }
    
    /*  Returns bool indicating if game finished or not, can't differentiate 
        between finish conditions
    */
    public boolean play(Integer diceRoll) {
        if (!turnManager.hasNext() ) {
            turnManager = gladiators.listIterator();
            turnCount++;
        }

        if (turnCount > MAX_ROUNDS) {;
            return true;  
        }

        //Picks next gladiator and plays the turn
        currentPlayer = turnManager.next();
        if (currentPlayer.playTurn(diceRoll)) { //todo aca hay un error. Si está lesionado y no juega, se ejecuta igualment la linea siguiente
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }

        if (gameBoard.pompeyaWasReached(currentPlayer) ) {
            return true;
        }

        return false;
    }

    public Gladiator getCurrentPlayer() {
        return currentPlayer;
    }
}
