package edu.fiuba.algo3.modelo;
import java.util.*;


import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.Log;
import edu.fiuba.algo3.modelo.TurnManager;
public class GameController {
    //private final List<Gladiator> players;
    private TurnManager turnManager;
    //private Gladiator currentPlayer;
    private final Board gameBoard;
    private IGameState gameState;
    //private Integer turnCount;

    public GameController(List<Gladiator> gladiators, Board board, IGameState game) {
        //players = gladiators;
        //turnManager = players.iterator();
        //currentPlayer = turnManager.next();
        gameBoard = board;
        gameState = game;
        //turnCount = 1;
        turnManager = new TurnManager(gladiators);
        //currentPlayer = turnManager.getCurrent();
    }
    
    //Randomizes the current player (used at the start)
    public void pickRandomPlayer(IDice dice) {
        turnManager.pickRandomPlayer(dice.roll());
        Log.getInstance().info("La partida comenzará con el jugador: " + getCurrentPlayer().getPlayerName());
        // turnCount = 0; //to prevent the reset from altering the rounds
    }

    //Plays individual turn
    public IGameState playTurn(IDice dice) {
        //Ends the game in case 30 turns were reached
        Gladiator currentPlayer = turnManager.getCurrent();
        updateGameState(currentPlayer, gameBoard, turnManager.getTurnCount());

        if (gameState.gameHasEnded()) {
            return gameState;
        }

        currentPlayer.playTurn(dice);

        //If the turn is played, update the game
        if (currentPlayer.turnPlayed()) {   //alternative to this: play turn returns the boolean
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }

        turnManager.next();

        return gameState;
    }

    //Changes the gameState class accordingly
    private void updateGameState(Gladiator currentPlayer, Board board, Integer rounds) {
        this.gameState = gameState.update(currentPlayer, board, rounds);
    }

    public Gladiator getCurrentPlayer() {
        return turnManager.getCurrent();
    }
    
}
