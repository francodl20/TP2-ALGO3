package edu.fiuba.algo3.modelo.attributes.gameState;

import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.Board;

public interface GameState {
    boolean gameHasEnded();

    GameState update(IPlayer currentPlayer, String playerName, Board board, Integer rounds);
}