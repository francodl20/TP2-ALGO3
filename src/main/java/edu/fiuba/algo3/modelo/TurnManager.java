package edu.fiuba.algo3.modelo;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.Gladiator;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.gameState.TieGameState;
import edu.fiuba.algo3.modelo.attributes.gameState.FinishedGameWithWinner;
import edu.fiuba.algo3.modelo.attributes.gameState.OngoingGame;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.attributes.gameState.GameState;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Square;

public class TurnManager {
    private final Integer MAX_ROUNDS = 30;
    private final Integer INITIAL_ENERGY = 20;
    private Iterator<Gladiator> turnManager;
    private Gladiator currentPlayer;
    private Integer turnCount;
    private Board gameBoard;
    private GameState gameState;
    private Map<Gladiator,String> players;
    
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
        Integer initialEnergy = INITIAL_ENERGY;

        for (int i = 0; i < amountOfPlayers; i++) {
            players.put(new Gladiator(new Novice(), 
                                        initialEnergy, 
                                        new Position(), 
                                        new Helpless()), listOfNames.get(i));
        }
        turnManager = players.keySet().iterator();
        gameBoard = board;
        turnCount = 1;
        currentPlayer = null;
    }
    
    public GameState play(DiceInterface dice) {
        if (!turnManager.hasNext() ) {
            turnManager = players.keySet().iterator();
            turnCount++;
        }

        updateGameState((Player)currentPlayer, gameBoard, turnCount);

        if (gameState.gameHasEnded()) {
            return gameState;
        }

        //Picks next gladiator and plays the turn
        currentPlayer = turnManager.next();
        if (currentPlayer.playTurn(dice)) {
            gameBoard.playAtCurrentPositionWith(currentPlayer);
        }

        updateGameState((Player)currentPlayer, gameBoard, turnCount);

        return gameState;
    }

    private void updateGameState(Player currentPlayer, Board board, Integer rounds) {
        this.gameState = gameState.update(currentPlayer, board, rounds);
    }

    public Gladiator getCurrentPlayer() {
        return currentPlayer;
    }
}
