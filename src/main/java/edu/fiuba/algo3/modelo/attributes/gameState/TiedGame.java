package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.Gladiator;

public class TiedGame implements IGameState {
    private final String WINNER_STATE;

    public TiedGame(){
        this.WINNER_STATE = "Game Tied.";
    }

    public boolean hasEnded(){
        return true;
    }

    public String getWinner() {
        return WINNER_STATE;
    }

    public IGameState update(Gladiator currentPlayer, Board board, Integer rounds) {
        return this;
    }
}