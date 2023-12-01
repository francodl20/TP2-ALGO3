package edu.fiuba.algo3.modelo.attributes.playerState;

import edu.fiuba.algo3.modelo.Gladiator;

public class Healthy implements IPlayerState {
    private Gladiator gladiator;
    private Boolean lastTurnPlayed;

    public Healthy(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    @Override
    public void update() {
        gladiator.updateStateOfInjuries(new Injured(gladiator));
    }

    @Override
    public void playTurn(Integer squaresToMove) {
        gladiator.moveFromCurrentPosition(squaresToMove);
        lastTurnPlayed = true;
    }

      @Override
    public boolean turnPlayed() {
        return lastTurnPlayed;
    }

}
