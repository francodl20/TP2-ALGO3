package edu.fiuba.algo3.modelo.attributes.playerState;
import edu.fiuba.algo3.modelo.Gladiator;

public class Injured implements IPlayerState {
    private Gladiator gladiator;
    private Boolean lastTurnPlayed;

    public Injured(Gladiator gladiator) {
        this.gladiator = gladiator;
        this.lastTurnPlayed = false;
    }

    @Override
    public void update() {
        gladiator.updateStateOfInjuries(new Healthy(gladiator));
    }

    @Override
    public void playTurn(Integer squaresToMove) {
        this.update();
        lastTurnPlayed = false;
    }

    @Override
    public boolean turnPlayed() {
        return lastTurnPlayed;
    }
}
