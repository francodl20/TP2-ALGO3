package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.Board;
//import edu.fiuba.algo3.modelo.attributes.gameState.FinishedGameWithWinner;

public class OngoingGame implements GameState {
    private final Integer MAX_ROUNDS = 30;
    private final String GAME_ONGOING = "Game Ongoing";
    public boolean gameHasEnded() {
        return false;
    }
    public String getWinner() {
        return GAME_ONGOING;
    }
    public GameState update(IPlayer currentPlayer, String playerName, Board board, Integer rounds) {
        if (rounds > MAX_ROUNDS) {
            return new TiedGameState();
        }
        if (currentPlayer.in(board.getPompeii())) {
            return new FinishedGameWithWinner(playerName);
        }
        return this;
    }
}