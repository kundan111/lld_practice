package io.binactivate.tic_tac_toe.exceptions;

public class SameSymbolforNewUserException extends RuntimeException{

    public SameSymbolforNewUserException(String message) {
        super(message);
    }
    
}
