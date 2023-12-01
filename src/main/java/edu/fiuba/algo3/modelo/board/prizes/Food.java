package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.Gladiator;

public class Food implements IPrize {

    public Food() { }

    public void boostGladiator(Gladiator player) {
        player.eat();
    }
}