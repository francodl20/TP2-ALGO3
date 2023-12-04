package edu.fiuba.algo3.modelo.attributes.gameState;

import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.board.Board;

public interface IGameState {
    boolean gameHasEnded();

    IGameState update(Gladiator currentPlayer, Board board, Integer rounds);

    String getWinner();
}