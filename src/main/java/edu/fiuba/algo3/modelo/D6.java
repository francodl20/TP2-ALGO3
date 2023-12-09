package edu.fiuba.algo3.modelo;
import java.util.Random;

public class D6 implements IDice{

    public Integer roll() {
        
        Random dice = new Random();
        return dice.nextInt(6) + 1;
    }
}