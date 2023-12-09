package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.Gladiator;

public class FinishedGameWithWinner implements IGameState {
    private final String WINNER;

    public FinishedGameWithWinner(Gladiator theWinner) {
        this.WINNER = theWinner.getPlayerName() + " has won the game.";
    }

    public String getWinner(){
        return WINNER;
    }

    public boolean hasEnded() {
        return true;
    }

    public IGameState update(Gladiator currentPlayer, Board board, Integer rounds) {
        return this;
    }
}
