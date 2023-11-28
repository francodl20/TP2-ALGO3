package edu.fiuba.algo3.modelo.attributes.gameState;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.Board;

public class TiedGameState implements IGameState {
    private final String GAME_ONGOING = "Game Tied";

    public boolean gameHasEnded(){
        return true;
    }
    public String getWinner() {
        return GAME_ONGOING;
    }
    public IGameState update(IPlayer currentPlayer, String playerName, Board board, Integer rounds) {
        return this;
    }
}