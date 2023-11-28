package edu.fiuba.algo3.modelo.attributes.gameState;

import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.Board;

public interface IGameState {
    boolean gameHasEnded();

    IGameState update(IPlayer currentPlayer, String playerName, Board board, Integer rounds);
}