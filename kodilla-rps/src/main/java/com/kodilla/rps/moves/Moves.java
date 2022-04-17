package com.kodilla.rps.moves;

import java.util.List;
import java.util.Map;

public enum Moves {

    NULL,
    ROCK,
    PAPER,
    SCISSORS,
    SPOCK,
    LIZARD;

    private static Moves[] list = Moves.values();

    public static Map<Moves, List<Moves>> winConditions = Map.of(
            ROCK,List.of(SCISSORS,LIZARD),
            PAPER,List.of(ROCK,SPOCK),
            SCISSORS,List.of(PAPER,LIZARD),
            SPOCK,List.of(SCISSORS,ROCK),
            LIZARD,List.of(SPOCK,PAPER)
    );


    public static Moves getMove(int i) {
        return list[i];


    }

    public static int getValueOf(Moves move){
        for ( int i = 0 ; i< list.length ; i++){
            if ( getMove(i) == move)
                return i;
        }
        return 0;
    }



}
