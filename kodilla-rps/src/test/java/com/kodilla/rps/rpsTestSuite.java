package com.kodilla.rps;


import com.kodilla.rps.moves.Move;
import com.kodilla.rps.moves.Moves;
import com.kodilla.rps.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kodilla.rps.moves.Moves.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class rpsTestSuite {

    @Test
    void testMoveComparison_Rock_Paper(){
        //Given
        Player player = mock(Player.class);
        Move rock  = new Move(ROCK,player);
        Move paper = new Move(PAPER,player);

        //TODO dlaczego List.of nie działa a ArrayList działa?
        //nie działa WTF?!
        //List<Move> moves = List.of(rock, paper);

        //działa
        List<Move> moves = new ArrayList<>();
        moves.add(rock);
        moves.add(paper);

        //When
        Collections.sort(moves);

        //then
        assertEquals(paper, moves.get(0));

    }

    @Test
    void testMoveComparison_Paper_Scissors(){
        //Given
        Player player = mock(Player.class);
        Move scissors  = new Move(SCISSORS,player);
        Move paper = new Move(PAPER,player);

        List<Move> moves = new ArrayList<>();
        moves.add(scissors);
        moves.add(paper);

        //When
        Collections.sort(moves);

        //then
        assertEquals(scissors, moves.get(0));

    }

    @Test
    void testForDraw(){
        //Given
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        Move rock  = new Move(ROCK,p1);
        Move rock2  = new Move(ROCK,p2);

        //when
        boolean result = rock.equals(rock2);

        //then
        assertTrue(result);
    }

    @Test
    void testMovesEnumGetByIndex(){
        //Given
        int testIndex = 2;
        int testIndex2 = 5;
        int testIndex3 = -1;
        int testIndex4 = 0;

        //When
        Moves t1 = getMove(testIndex);
        Moves t2 = getMove(testIndex2);
        Moves t3 = getMove(testIndex3);
        Moves t4 = getMove(testIndex4);

        //Then
        assertEquals(PAPER, t1);
        assertEquals(LIZARD, t2);
        assertEquals(NULL, t3);
        assertEquals(NULL, t4);

    }

    //TODO add test for getValueOf(Moves move)

}
