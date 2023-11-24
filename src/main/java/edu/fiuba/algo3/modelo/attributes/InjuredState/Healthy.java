package edu.fiuba.algo3.modelo.attributes.InjuredState;

import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Position;

public class Healthy implements InjuredState {
    private Gladiator gladiator;

    public Healthy(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    @Override
    public void update() {
        gladiator.updateInjuries(new Injured(gladiator));
    }

    @Override
    public void playTurn(Integer squaresToMove) {
        gladiator.moveFromCurrentPosition(new Position(squaresToMove));
    }
}
