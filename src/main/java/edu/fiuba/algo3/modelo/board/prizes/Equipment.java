package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.Log;
public class Equipment implements IPrize {

    public void boostGladiator(Gladiator player) {
        player.enhanceArmour();
    }

 
}