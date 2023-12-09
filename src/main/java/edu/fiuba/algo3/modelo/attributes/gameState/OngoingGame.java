package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.Gladiator;

public class OngoingGame implements IGameState {
    private final Integer MAX_ROUNDS = 30;
    private final String WINNER_STATE;

    Gladiator player;

    public OngoingGame(){
        this.WINNER_STATE = "There's no winner yet.";
    }

    public boolean hasEnded() {
        return false;
    }

    public String getWinner() {
        return WINNER_STATE;
    }

    public IGameState update(Gladiator currentPlayer, Board board, Integer rounds) {
        this.player = currentPlayer;
        
        if (board.pompeiiHas(currentPlayer)) { 
            return new FinishedGameWithWinner(currentPlayer);
        }
        if (rounds > MAX_ROUNDS) {
            return new TiedGameState();
        }
        return this;
    }
}