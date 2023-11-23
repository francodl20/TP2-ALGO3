package edu.fiuba.algo3.modelo.attributes.InjuredState;

import edu.fiuba.algo3.modelo.Gladiator;

public class Injured implements InjuredState {
    private Gladiator gladiator;

    public Injured(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    @Override
    public void update() {
        gladiator.updateInjuries(new Healthy(gladiator));
    }
}
