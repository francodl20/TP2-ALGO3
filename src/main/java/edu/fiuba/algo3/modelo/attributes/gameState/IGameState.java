package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.Gladiator;

public interface IGameState {
    boolean hasEnded();

    IGameState update(Gladiator currentPlayer, Board board, Integer rounds);

    String getWinner();
}