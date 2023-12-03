package edu.fiuba.algo3.modelo;
import java.util.*;


import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.Log;

public class TurnManager {
    private final List<Gladiator> players;
    private Iterator<Gladiator> turnManager;
    private Gladiator currentPlayer;
    private final Board gameBoard;
    private IGameState gameState;
    private Integer turnCount;

    public TurnManager(List<Gladiator> gladiators, Board board, IGameState game) {
        players = gladiators;
        turnManager = players.iterator();
        currentPlayer = turnManager.next();
        gameBoard = board;
        gameState = game;
        turnCount = 1;
    }
    
    //Randomizes the current player (used at the start)
    public void pickRandomPlayer(IDice dice) {
        for (int i = 0; i < dice.roll(); i++) {
            resetIterator();
            currentPlayer = turnManager.next();
        }
        Log.getInstance().info("La partida comenzará con el jugador: " + currentPlayer.getPlayerName());
        turnCount = 0; //to prevent the reset from altering the rounds
    }
    
    //Resets the iterator when it reaches the end
    private void resetIterator() {
        if (!turnManager.hasNext()) {
            turnManager = players.iterator();
            turnCount++;
        }
    }

    //Plays individual turn
    public IGameState playTurn(IDice dice) {
        //Ends the game in case 30 turns were reached
        updateGameState(currentPlayer, gameBoard, turnCount);
        if (gameState.gameHasEnded()) {
            return gameState;
        }
        
        currentPlayer.playTurn(dice);

        //If the turn is played, update the game
        if (currentPlayer.turnPlayed()) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }


        //Ends the game in case pompeii was reached
        updateGameState(currentPlayer, gameBoard, turnCount);
        
        resetIterator();
        currentPlayer = turnManager.next();
        
        return gameState;
    }

    //Changes the gameState class accordingly
    private void updateGameState(Gladiator currentPlayer, Board board, Integer rounds) {
        this.gameState = gameState.update(currentPlayer, board, rounds);
    }

    //Illegal
    public Gladiator getCurrentPlayer() {
        return currentPlayer;
    }
    
}
