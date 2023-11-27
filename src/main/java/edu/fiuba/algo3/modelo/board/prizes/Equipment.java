package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.IPlayer;

public class Equipment implements IPrize {

    public void boostGladiator(IPlayer player) {
        player.enhanceArmour();
    }

 
}