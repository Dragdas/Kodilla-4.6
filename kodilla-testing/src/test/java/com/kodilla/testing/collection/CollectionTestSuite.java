package com.kodilla.testing.collection;


import org.junit.jupiter.api.*;

import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void befor(){
        System.out.println("OddNumberExterminator test start");
    }

    @AfterEach
    public void after(){
        System.out.println("OddNumberExterminator test end");
    }


    @DisplayName("OddNumberExterminator test case with empty list")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> testingList = List.of();

        //When
        List<Integer> result = OddNumbersExterminator.exterminate(testingList);

        List<Integer> expectedResult = List.of();

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("OddNumberExterminator test case with normal list")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        List<Integer> testingList = List.of(564,165,12,54,2165,554,165,165,5);

        //When
        List<Integer> result = OddNumbersExterminator.exterminate(testingList);

        List<Integer> expectedResult = List.of(564,12,54,554);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }



}
