package edu.fiuba.algo3.modelo;
import java.util.*;


import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.board.Board;

public class TurnManager {
    private final Map<Gladiator,String> players;
    private Iterator<Gladiator> turnManager;
    private Gladiator currentPlayer;
    private final Board gameBoard;
    private IGameState gameState;
    private Integer turnCount;

    public TurnManager(List<Gladiator> gladiators, List<String> listOfNames, Board board, IGameState game) {
        players = new LinkedHashMap<>(); //ordered hash map
        gladiators.forEach(gladiator ->
            players.put(gladiator, listOfNames.get(gladiators.indexOf(gladiator))));
        turnManager = players.keySet().iterator();
        currentPlayer = turnManager.next();
        gameBoard = board;
        gameState = game;
        turnCount = 1;
    }
    
    //Randomizes the current player (used at the start)
    public void pickRandomPlayer(IDice dice) {
        for (int i = 0; i < dice.roll(); i++) {
            resetIterator();
            turnManager.next();
        }
        turnCount = 0; //to prevent the reset from altering the rounds
    }
    
    //Resets the iterator when it reaches the end
    private void resetIterator() {
        if (!turnManager.hasNext()) {
            turnManager = players.keySet().iterator();
            turnCount++;
        }
    }

    //Plays individual turn
    public IGameState playTurn(IDice dice) {
        
        //Ends the game in case 30 turns were reached
        updateGameState(currentPlayer, players.get(currentPlayer), gameBoard, turnCount);
        if (gameState.gameHasEnded()) {
            return gameState;
        }
        
        //Picks next gladiator and plays the turn
        if (currentPlayer.playTurn(dice)) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }
        
        //Ends the game in case pompeii was reached
        updateGameState(currentPlayer, players.get(currentPlayer), gameBoard, turnCount);
        
        resetIterator();
        currentPlayer = turnManager.next();
        
        return gameState;
    }

    //Changes the gameState class accordingly
    private void updateGameState(IPlayer currentPlayer, String playerName, Board board, Integer rounds) {
        this.gameState = gameState.update(currentPlayer, playerName, board, rounds);
    }

    //Illegal
    public Gladiator getCurrentPlayer() {
        return currentPlayer;
    }
}
