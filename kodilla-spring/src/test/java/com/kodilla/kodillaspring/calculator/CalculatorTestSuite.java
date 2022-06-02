package com.kodilla.kodillaspring.calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //When
        double result1 = calculator.add(1,5);
        double result2 = calculator.add(5,5);
        double result3 = calculator.add(10,5);

        //Then
        assertEquals(6,result1);
        assertEquals(10,result2);
        assertEquals(15,result3);

        //When
        double result4 = calculator.sub(1,5);
        double result5 = calculator.sub(5,5);
        double result6 = calculator.sub(10,5);

        //Then
        assertEquals(-4,result4);
        assertEquals(0,result5);
        assertEquals(5,result6);

        //When
        double result7 = calculator.mul(1,5);
        double result8 = calculator.mul(5,5);
        double result9 = calculator.mul(10,5);

        //Then
        assertEquals(5,result7);
        assertEquals(25,result8);
        assertEquals(50,result9);

        //When
        double result10 = calculator.div(5,5);
        double result11 = calculator.div(10,5);
        double result12 = calculator.div(10,0);

        //Then
        assertEquals(1,result10);
        assertEquals(2,result11);
        assertEquals(0,result12);


    }


}
