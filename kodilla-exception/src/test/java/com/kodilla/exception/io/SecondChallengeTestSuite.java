package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException(){

        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(5, 1.5));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 2));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 1));
    }

    @Test
    void testDontThrowProbablyIWillThrowException(){

        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2));

    }


}
