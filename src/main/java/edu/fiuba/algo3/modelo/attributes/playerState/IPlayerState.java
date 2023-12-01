package edu.fiuba.algo3.modelo.attributes.playerState;

public interface IPlayerState {
    public void update();

    public void playTurn(Integer squaresToMove);

    public boolean turnPlayed();
}
