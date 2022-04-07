package io.binactivate.tic_tac_toe.model;

public class User {
    private String name;
    private boolean isWinner;
    private char playingSymbol;

    public User(String name, boolean isWinner, char playingSymbol) {
        this.name = name;
        this.isWinner = isWinner;
        this.playingSymbol = playingSymbol;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public char getPlayingSymbol() {
        return playingSymbol;
    }

    public void setPlayingSymbol(char playingSymbol) {
        this.playingSymbol = playingSymbol;
    }

    

    
}
