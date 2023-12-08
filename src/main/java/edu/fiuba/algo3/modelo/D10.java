package edu.fiuba.algo3.modelo;

import java.util.Random;

public class D10 implements IDice{

    public Integer roll() {
        
        Random dice = new Random();
        return dice.nextInt(10) + 1;
    }
}
