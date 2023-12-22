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
    public IPlayerState update() {
        return new Healthy(gladiator);
    }

    @Override
    public IPlayerState playTurn(Integer squaresToMove) {
        return this.update();
    }

    @Override
    public boolean turnPlayed() {
        return lastTurnPlayed;
    }

    public String getPlayerState(){
        return "Herido";
    }
}
