package edu.fiuba.algo3.modelo.attributes.playerState;

import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Position;

public class Healthy implements IPlayerState {
    private Gladiator gladiator;

    public Healthy(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    @Override
    public void update() {
        gladiator.updateStateOfInjuries(new Injured(gladiator));
    }

    @Override
    public boolean playTurn(Integer squaresToMove) {
        gladiator.moveFromCurrentPosition(new Position(squaresToMove));
        return true;
    }
}
