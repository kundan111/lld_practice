package io.binactivate.tic_tac_toe.exceptions;

public class CellAlreadyFilledException extends RuntimeException{

    public CellAlreadyFilledException(String message) {
        super(message);
    }
    
}
