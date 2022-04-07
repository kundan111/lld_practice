package io.binactivate.tic_tac_toe.exceptions;

public class IllegalBoardDimension extends RuntimeException{

    public IllegalBoardDimension(String message) {
        super(message);
    }
    
}
