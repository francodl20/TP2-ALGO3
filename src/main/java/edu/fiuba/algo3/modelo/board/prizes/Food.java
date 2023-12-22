package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.Log;

public class Food implements IPrize {

    public Food() { }

    public void boost(Gladiator player) {
        player.eat();
    }
}