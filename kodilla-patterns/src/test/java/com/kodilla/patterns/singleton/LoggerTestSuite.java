package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    void testLogg(){

        //Given
        Logger logger = Logger.getInstance();

        //When
        logger.log("Test logging");

        //Then
        Assertions.assertEquals("Test logging", logger.getLastLog());

    }


}
