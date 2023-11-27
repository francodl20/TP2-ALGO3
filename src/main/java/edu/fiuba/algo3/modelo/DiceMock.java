package edu.fiuba.algo3.modelo;

public class DiceMock implements IDice{
    Integer number;

    public DiceMock(Integer fixedNum){
        number = fixedNum;
    }

    public Integer roll(){
        return number;
    }
}
