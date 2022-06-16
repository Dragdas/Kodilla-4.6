package com.kodilla.testing.loop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testLoopAndConditionalBreakpoints {

    @Test
    void testLoop(){

        long sum = 0;

        for( int i = 0 ; i < 1000; i++){
            sum += i;
            System.out.println("[" + i +"] Sum equals: " + sum);
        }

        Assertions.assertEquals(499500, sum);

    }

}
