package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.Gladiator;

public class FinishedGameWithWinner implements IGameState {

    Gladiator winner;

    public FinishedGameWithWinner(Gladiator theWinner) {
        this.winner = theWinner;
    }

    public Gladiator getWinner(){
        return winner;
    }

    public boolean gameHasEnded() {
        return true;
    }

    public IGameState update(Gladiator currentPlayer, Board board, Integer rounds) {
        return this;
    }
}
