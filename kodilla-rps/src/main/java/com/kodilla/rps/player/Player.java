package com.kodilla.rps.player;

import com.kodilla.rps.moves.Move;

public abstract class Player {

    protected Move lastMove;
    protected String name;
    private int score = 0;

    public void addPoint(){
        score++;
    }

    public abstract Move generateMove(int moveNo);

    public Move getLastMove() {
        return lastMove;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
