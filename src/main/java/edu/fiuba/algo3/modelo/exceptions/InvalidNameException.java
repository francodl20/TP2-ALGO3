package edu.fiuba.algo3.modelo.exceptions;

public class InvalidNameException extends Exception{
    public InvalidNameException() { 
        super("Name has to be at least 4 leters");
    }
}
