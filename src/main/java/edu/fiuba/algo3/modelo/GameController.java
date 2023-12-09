package edu.fiuba.algo3.modelo;
import java.util.*;

import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.Log;

public class GameController {
    private final Board GAMEBOARD;
    private TurnManager turnManager;
    private IGameState gameState;

    public GameController(List<Gladiator> gladiators, Board board, IGameState game) {
        GAMEBOARD = board;
        gameState = game;
        turnManager = new TurnManager(gladiators);
    }
    
    //Randomizes the current player (used at the start)
    public void pickRandomPlayer(IDice dice) {
        turnManager.pickRandomPlayer(dice.roll());

        Log.getInstance().info(
            "La partida comenzará con el jugador: " + getCurrentPlayer().getPlayerName());
    }

    //Plays individual turn
    public IGameState playTurn(IDice dice) {

        //Ends the game in case 30 turns were reached
        Gladiator currentPlayer = turnManager.getNextGladiator();
        updateGameState(currentPlayer, GAMEBOARD, turnManager.getTurnCount());
        if (gameState.hasEnded()) {
            return gameState;
        }

        currentPlayer.playTurn(dice);

        //If the turn is played, update the game
        if (currentPlayer.turnPlayed()) {   //alternative to this: play turn returns the boolean
            GAMEBOARD.playAtCurrentPositionWith(currentPlayer);
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
    
}
