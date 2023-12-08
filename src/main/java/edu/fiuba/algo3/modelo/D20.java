package edu.fiuba.algo3.modelo;

import java.util.Random;

public class D20 implements IDice{

    public Integer roll() {
        
        Random dice = new Random();
        return dice.nextInt(20) + 1;
    }
}
