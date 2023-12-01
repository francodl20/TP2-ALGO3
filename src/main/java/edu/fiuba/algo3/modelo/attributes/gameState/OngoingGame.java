package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.Gladiator;
//import edu.fiuba.algo3.modelo.attributes.gameState.FinishedGameWithWinner;

public class OngoingGame implements IGameState {
    private final Integer MAX_ROUNDS = 30;
    private final String GAME_ONGOING = "Game Ongoing";

    Gladiator player;

    public boolean gameHasEnded() {
        return false;
    }
    public String getWinner() {
        return GAME_ONGOING;
    }
    public IGameState update(Gladiator currentPlayer, Board board, Integer rounds) {
        this.player = currentPlayer;

        if (rounds > MAX_ROUNDS) {
            return new TiedGameState();
        }
        if (currentPlayer.in(board.getPompeii())) {
            return new FinishedGameWithWinner(player);
        }
        return this;
    }
}