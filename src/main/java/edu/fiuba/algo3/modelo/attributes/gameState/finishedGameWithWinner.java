package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.Board;

public class FinishedGameWithWinner implements GameState {
   
    String winner;

    public FinishedGameWithWinner(String theWinner) {
        this.winner = theWinner;
    }

    public String getWinner(){
        return winner;
    }

    public boolean gameHasEnded() {
        return true;
    }

    public GameState update(IPlayer currentPlayer,String playerName,  Board board, Integer rounds) {
        return this;
    }
    
}
