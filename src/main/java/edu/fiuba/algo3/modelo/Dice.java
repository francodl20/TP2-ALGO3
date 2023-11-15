package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dice {

    public static int rollDice() {
        
        Random dice = new Random();
        return dice.nextInt(6) + 1;
    }
}