package edu.fiuba.algo3.modelo;
import java.util.*;


import edu.fiuba.algo3.modelo.attributes.gameState.GameState;
import edu.fiuba.algo3.modelo.board.Board;

public class TurnManager {
    private final Map<Gladiator,String> players;
    private Iterator<Gladiator> turnManager;
    private Gladiator currentPlayer;
    private final Board gameBoard;
    private GameState gameState;
    private Integer turnCount;

    public TurnManager(List<Gladiator> gladiators, List<String> listOfNames, Board board, GameState game) {
        players = new LinkedHashMap<>(); //ordered hash map
        gladiators.forEach(gladiator ->
            players.put(gladiator, listOfNames.get(gladiators.indexOf(gladiator))));
        turnManager = players.keySet().iterator();
        currentPlayer = turnManager.next();
        gameBoard = board;
        gameState = game;
        turnCount = 1;
    }
    
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

    public GameState playTurn(IDice dice) {
        resetIterator();

        //Ends the game in case 30 turns were reached
        updateGameState(currentPlayer, players.get(currentPlayer), gameBoard, turnCount);
        if (gameState.gameHasEnded()) {
            return gameState;
        }

        //Picks next gladiator and plays the turn
        currentPlayer = turnManager.next();
        if (currentPlayer.playTurn(dice)) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }

        //Ends the game in case pompeii was reached
        updateGameState(currentPlayer, players.get(currentPlayer), gameBoard, turnCount);

        return gameState;
    }

    private void updateGameState(IPlayer currentPlayer, String playerName, Board board, Integer rounds) {
        this.gameState = gameState.update(currentPlayer, playerName, board, rounds);
    }

    public Gladiator getCurrentPlayer() {
        return currentPlayer;
    }
}
