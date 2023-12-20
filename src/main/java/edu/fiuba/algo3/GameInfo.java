package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.GameController;

public final class GameInfo {
    
    //GameData
    private static Integer playerAmount;
    private static GameController game;

    public static void setPlayerAmount(Integer amount) {
        playerAmount = amount;
    }

    public static Integer getPlayerAmount() {
        return playerAmount;
    }

    public static void setGame(GameController newGame) {
        game = newGame;
    }

    public static GameController getGame() {
        return game;
    }

    //SoundData

    private static SoundController soundController;

    public static void setSoundController(SoundController mPlayer) {
        soundController = mPlayer;
    }

    public static SoundController getSoundController() {
        return soundController;
    }
}
