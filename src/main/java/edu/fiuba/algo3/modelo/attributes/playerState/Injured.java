package edu.fiuba.algo3.modelo.attributes.playerState;

import edu.fiuba.algo3.modelo.Gladiator;

public class Injured implements PlayerState {
    private Gladiator gladiator;

    public Injured(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    @Override
    public void update() {
        gladiator.updateStateOfInjuries(new Healthy(gladiator));
    }

    @Override
    public boolean playTurn(Integer squaresToMove) {
        this.update();
        return false;
    }
}
