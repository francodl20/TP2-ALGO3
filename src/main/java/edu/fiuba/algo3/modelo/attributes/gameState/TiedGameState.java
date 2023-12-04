package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.board.Board;

public class TiedGameState implements IGameState {
    private final String WINNER_STATE = "Game Tied.";

    public boolean gameHasEnded(){
        return true;
    }
    public String getWinner() {
        return WINNER_STATE;
    }
    public IGameState update(Gladiator currentPlayer, Board board, Integer rounds) {
        return this;
    }
}