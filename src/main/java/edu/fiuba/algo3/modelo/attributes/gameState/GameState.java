package edu.fiuba.algo3.modelo.attributes.gameState;

import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.board.Board;

public interface GameState {
    boolean gameHasEnded();

    Player getWinner();

    boolean maxMovesReached();

}
