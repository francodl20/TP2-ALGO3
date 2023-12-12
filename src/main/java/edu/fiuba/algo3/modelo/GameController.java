package edu.fiuba.algo3.modelo;
import java.util.*;

import edu.fiuba.algo3.modelo.exceptions.InvalidJSONFormatException;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.attributes.gameState.OngoingGame;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.Log;

public class GameController {
    private final Board GAMEBOARD;
    private TurnManager turnManager;
    private IGameState gameState;
    private Integer lastDiceRoll = 0;

    //Default constructor
    public GameController(List<String> gladiatorNames, Integer numberOfPlayers) {
        GAMEBOARD = instanceBoard();
        gameState = new OngoingGame();
        turnManager = new TurnManager(instanceGladiators(gladiatorNames, numberOfPlayers));
    }

    public GameController(List<Gladiator> gladiators, Board board, IGameState game) {
        GAMEBOARD = board;
        gameState = game;
        turnManager = new TurnManager(gladiators);
    }
    
    private Board instanceBoard(){
        Board board = null;
        try {
            board = new Board("src/main/resources/JSonFiles/board.json");
        } catch (InvalidJSONFormatException exception) {
            // TODO: handle exception
        } catch (Exception exception) {
            // TODO: handle exception
        }
        return board;

    }
    
    private List<Gladiator> instanceGladiators(List<String> gladiatorNames, Integer numberOfPlayers){
        List<Gladiator> gladiators = new LinkedList<>();
        
        for (Integer i = 0; i < numberOfPlayers; i++) {
            gladiators.add(new Gladiator(gladiatorNames.get((int)i)));
        }
    
        return gladiators;
    }
    
    //Randomizes the current player (used at the start)
    public void pickRandomPlayer(IDice dice) {
        turnManager.pickRandomPlayer(dice.roll());

        Log.getInstance().info(
            "La partida comenzará con el jugador: " + getCurrentPlayer().getName());
    }

    //Plays individual turn
    public IGameState playTurn(IDice dice) {

        //Ends the game in case 30 turns were reached
        Gladiator currentPlayer = turnManager.getNextGladiator();
        updateGameState(currentPlayer, GAMEBOARD, turnManager.getTurnCount());
        if (gameState.hasEnded()) {
            return gameState;
        }

        this.lastDiceRoll = currentPlayer.playTurn(dice);

        //If the turn is played, update the game
        if (currentPlayer.turnPlayed()) {   //alternative to this: play turn returns the boolean
            GAMEBOARD.playWith(currentPlayer);
        }

        return gameState;
    }

    //Changes the gameState class accordingly
    private void updateGameState(Gladiator currentPlayer, Board board, Integer rounds) {
        this.gameState = gameState.update(currentPlayer, board, rounds);
    }

    public Gladiator getCurrentPlayer() {
        return turnManager.getCurrentGladiator();
    }

    public Integer getLastDiceRoll(){
        return this.lastDiceRoll;
    }
    
}
