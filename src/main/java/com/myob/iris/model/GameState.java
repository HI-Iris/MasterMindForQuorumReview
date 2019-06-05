package com.myob.iris.model;


public class GameState {
    private boolean win;
    private int attempts;

    public GameState() {
        this.win = false;
        this.attempts = 0;
    }

    public boolean isWon() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getAttempts() {
        return attempts;
    }

    public void increaseAttempt() {
        this.attempts += 1;
    }
}
