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

    //TurnData
        //Actions
    private static String moveInfo = "";
    private static String prizeInfo = "";
    private static String obstacleInfo = "";
        //Status
    private static String name = "";
    private static String energy = "20";
    private static String equipment = "nada";
    private static String seniority = "Novato";
    private static Integer position = 1;

    public static void resetTurnData() {
        moveInfo = "";
        prizeInfo = "";
        obstacleInfo = "";

        name = "";
        energy = "20";
        equipment = "nada";
        seniority = "Novato";
        position = 1;
    }

    public static void setMoveInfo(String message) {
        moveInfo = message;
    }

    public static String getMoveInfo() {
        return moveInfo;
    }

    public static void setPrizeInfo(String message) {
        prizeInfo = message;
    }

    public static String getPrizeInfo() {
        return prizeInfo;
    }

    public static void setObstacleInfo(String message) {
        obstacleInfo = message;
    }

    public static String getObstacleInfo() {
        return obstacleInfo;
    }

    public static void setName(String newName) {
        name = newName;
    }

    public static String getName() {
        return name;
    }

    public static void setEnergy(Integer newEnergy) {
        energy = newEnergy.toString();
    }

    public static String getEnergy() {
        return energy;
    }

    public static void setEquipment(String newEquipment) {
        equipment = newEquipment;
    }

    public static String getEquipment() {
        return equipment;
    }

    public static void setSeniority(String newSeniority) {
        seniority = newSeniority;
    }

    public static String getSeniority() {
        return seniority;
    }

    public static void setPosition(Integer newPosition) {
        position = newPosition;
    }

    public static Integer getPosition() {
        return position;
    }

}
