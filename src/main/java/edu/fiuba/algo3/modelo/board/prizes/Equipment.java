package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.Gladiator;
;
public class Equipment implements IPrize {

    public void boost(Gladiator player) {
        player.enhanceArmour();
    }

}