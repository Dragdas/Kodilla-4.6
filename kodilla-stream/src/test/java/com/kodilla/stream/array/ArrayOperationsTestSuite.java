package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        int[] numbers = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                         20, 20, 20, 20, 20, 20, 20, 20, 20, 20};


        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(15,result);


    }


}
