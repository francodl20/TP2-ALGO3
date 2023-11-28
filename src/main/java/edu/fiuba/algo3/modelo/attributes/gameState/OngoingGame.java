package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.Board;
//import edu.fiuba.algo3.modelo.attributes.gameState.FinishedGameWithWinner;

public class OngoingGame implements IGameState {
    private final Integer MAX_ROUNDS = 30;
    private final String GAME_ONGOING = "Game Ongoing";

    String playerName;

    public boolean gameHasEnded() {
        return false;
    }
    public String getWinner() {
        return GAME_ONGOING;
    }
    public IGameState update(IPlayer currentPlayer, String playerName, Board board, Integer rounds) {
        this.playerName = playerName;

        if (rounds > MAX_ROUNDS) {
            return new TiedGameState();
        }
        if (currentPlayer.in(board.getPompeii())) {
            return new FinishedGameWithWinner(playerName);
        }
        return this;
    }
}