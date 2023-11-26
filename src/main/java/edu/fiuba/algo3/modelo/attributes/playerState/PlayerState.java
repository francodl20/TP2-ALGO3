package edu.fiuba.algo3.modelo.attributes.playerState;

public interface PlayerState {
    public void update();

    public boolean playTurn(Integer squaresToMove);
}
