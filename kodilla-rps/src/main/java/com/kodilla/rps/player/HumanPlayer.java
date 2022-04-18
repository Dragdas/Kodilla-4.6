package com.kodilla.rps.player;

import com.kodilla.rps.moves.Move;
import com.kodilla.rps.moves.Moves;

import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer() {
        this.name = askForName();
    }

    private String askForName(){
        System.out.println("Please enter your name: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public String toString() {
        return "HumanPlayer{" +
                "name='" + name + '\'' +
                "Score= " + getScore() +
                '}';
    }

    @Override
    public Move generateMove(int moveNo) {
        lastMove = new Move(Moves.getMove(moveNo), this);
        return lastMove;
    }
}
