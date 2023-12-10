package edu.fiuba.algo3.modelo.attributes.playerState;

public interface IPlayerState {
    public IPlayerState update();

    public IPlayerState playTurn(Integer squaresToMove);

    public boolean turnPlayed();
}
