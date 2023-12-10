package edu.fiuba.algo3.modelo.attributes.playerState;
import edu.fiuba.algo3.modelo.Gladiator;

public class Healthy implements IPlayerState {
    private Gladiator gladiator;
    private Boolean lastTurnPlayed;

    public Healthy(Gladiator gladiator) {
        this.gladiator = gladiator;
        this.lastTurnPlayed = false;
    }

    @Override
    public IPlayerState update() {
        return new Injured(gladiator);
    }

    @Override
    public IPlayerState playTurn(Integer squaresToMove) {
        gladiator.advance(squaresToMove);
        lastTurnPlayed = true;
        return this;
    }

      @Override
    public boolean turnPlayed() {
        return lastTurnPlayed;
    }

}
