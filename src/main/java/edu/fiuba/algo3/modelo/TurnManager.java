package edu.fiuba.algo3.modelo;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.Gladiator;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.gameState.TieGameState;
import edu.fiuba.algo3.modelo.attributes.gameState.finishedGameWithWinner;
import edu.fiuba.algo3.modelo.attributes.gameState.startedAndNotFinishedGame;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.attributes.gameState.GameState;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Square;
import
public class TurnManager {
    private final Integer MAX_ROUNDS = 30;
    private final Integer INITIAL_ENERGY = 20;
    private List<Gladiator> gladiators;
    private ListIterator<Gladiator> turnManager;
    private Gladiator currentPlayer;
    private Integer turnCount;
    private Board gameBoard;
    private GameState gameState;
    
    
    public TurnManager(List<Gladiator> listOfGladiators, Board board, GameState game) {
        gladiators = listOfGladiators;
        turnManager = gladiators.listIterator();
        gameBoard = board;
        gameState = game;
        turnCount = 1;
        currentPlayer = null;
    }

    public TurnManager(Integer amountOfPlayers, Board board) {
        gladiators = new LinkedList<Gladiator>();
        Integer initialEnergy = INITIAL_ENERGY;  //REVISAR ENERGIA INICIAL

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
    public GameState play(Integer diceRoll) {
        if (!turnManager.hasNext() ) {
            turnManager = gladiators.listIterator();
            turnCount++;
        }

        if (turnCount > MAX_ROUNDS) {;
            gameState = updateState();
        }

        if (gameState.gameHasEnded()) {
            return gameState;
        }

        //Picks next gladiator and plays the turn
        currentPlayer = turnManager.next();
        if (currentPlayer.playTurn(diceRoll)) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }

        gameState = updateState(currentPlayer, gameBoard);

        return gameState;
    }

    private GameState updateState(Player current, Board board) {
        if (current.in(board.getToPompeii())) {
            return new finishedGameWithWinner(current);
        }
        return new startedAndNotFinishedGame();
    }
    private GameState updateState() {
        return new TieGameState();
    }
    public Gladiator getCurrentPlayer() {
        return currentPlayer;
    }
}
