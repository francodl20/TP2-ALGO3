package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.IPrize;

public class Food implements IPrize {

    public Food() { }

    public void boostGladiator(IPlayer player) {
        player.eat();
    }
}