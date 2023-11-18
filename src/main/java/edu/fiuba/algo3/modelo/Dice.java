package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dice {

    public static Integer roll() {
        
        Random dice = new Random();
        return dice.nextInt(6) + 1;
    }
}