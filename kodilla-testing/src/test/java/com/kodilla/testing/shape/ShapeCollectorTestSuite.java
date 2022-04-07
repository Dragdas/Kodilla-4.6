package com.kodilla.testing.shape;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: ShapeCollector Test Suite ")
public class ShapeCollectorTestSuite {

    private static int testCounter=0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start of ShapeCollector test");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("End of ShapeCollector test");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("List manipulation tests")
    class TestListManipulation{

        @Test
        void testAddFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square sq = new Square(5d);
            //When
            shapeCollector.addFigure(sq);
            int result = shapeCollector.getShapesQuantity();
            //Then
            assertEquals(1,result);
        }

        @Test
        void removeFigureNotExist(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle t = new Triangle(54d,5d);

            //When
            boolean result = shapeCollector.removeFigure(t);

            //Then
            assertFalse(result);
        }

        @Test
        void removeFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square sq = new Square(5d);
            shapeCollector.addFigure(sq);

            //When
            boolean result = shapeCollector.removeFigure(sq);

            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getShapesQuantity());
        }

    }

    @Nested
    @DisplayName("Shape display tests")
    class TestShapeDisplayMethods{

        @Test
        void testGetFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square sq = new Square(5d);
            shapeCollector.addFigure(sq);

            //When
            Shape result = shapeCollector.getFigure(0);

            //Then
            assertEquals(sq, result);

        }

        @Test
        void testShowFigures(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square sq = new Square(5d);
            shapeCollector.addFigure(sq);
            Triangle t = new Triangle(54d,5d);
            shapeCollector.addFigure(t);

            //when
            String result = shapeCollector.showFigures();

            //then
            assertEquals("SquareTriangle", result);

        }

    }
}
