package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;

public class PompeyaSquare implements Square {

    @Override
    public void play(Player player) {
        player.arriveToPompeya();
    }
}