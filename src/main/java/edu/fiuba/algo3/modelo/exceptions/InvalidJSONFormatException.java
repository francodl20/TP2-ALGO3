package edu.fiuba.algo3.modelo.exceptions;

public class InvalidJSONFormatException extends Exception{
    public InvalidJSONFormatException(String errorMessage){
        super(errorMessage);
    }
}
