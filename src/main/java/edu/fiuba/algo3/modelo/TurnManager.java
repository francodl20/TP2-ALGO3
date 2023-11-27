package edu.fiuba.algo3.modelo;
import java.util.*;


import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.attributes.gameState.GameState;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.board.Board;

public class TurnManager {
    private final Integer MAX_ROUNDS = 30;
    private final Integer INITIAL_ENERGY = 20;
    private Iterator<Gladiator> turnManager;
    private Gladiator currentPlayer;
    private Integer turnCount;
    private final Board gameBoard;
    private GameState gameState;
    private final Map<Gladiator,String> players;

    public TurnManager(List<Gladiator> gladiators, List<String> listOfNames, Board board, GameState game) {
        players = new LinkedHashMap<>(); //map que guarda el orden de los elementos
        gameBoard = board;
        gameState = game;
        turnCount = 1;
        currentPlayer = null;
        gladiators.forEach(gladiator ->
            players.put(gladiator,listOfNames.get(gladiators.indexOf(gladiator)))
        );
        turnManager = players.keySet().iterator();
    }

    public TurnManager(Integer amountOfPlayers, List<String> listOfNames, Board board) {
        players = new LinkedHashMap<>();

        for (int i = 0; i < amountOfPlayers; i++) {
            players.put(new Gladiator(new Novice(),
                                        INITIAL_ENERGY,
                                        new Position(), 
                                        new Helpless()), listOfNames.get(i));
        }
        turnManager = players.keySet().iterator();
        gameBoard = board;
        turnCount = 1;
        currentPlayer = null;
    }
    
    public GameState playOneTurn(IDice dice) {
        if (!turnManager.hasNext() ) {
            turnManager = players.keySet().iterator();
            turnCount++;
        }

        updateGameState(currentPlayer, players.get(currentPlayer), gameBoard, turnCount);

        if (gameState.gameHasEnded()) {
            return gameState;
        }

        //Picks next gladiator and plays the turn
        currentPlayer = turnManager.next();
        if (currentPlayer.playTurn(dice)) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }

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
