package solverTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sudokuGame.board.Board;
import sudokuGame.board.WrongCoordinatesException;
import sudokuGame.solver.Solver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SolverTestSuit {

    @Test
    void updatePossibleValues(){
        //given
        Board board = new Board();
        Solver solver = new Solver();

        try {
            board.getCellByCoordinates(1,1).setValue(1);
            board.getCellByCoordinates(2,2).setValue(2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //when
        solver.solve(board);

        List<Integer> possibleValues = new ArrayList<>();

        try {
            possibleValues.addAll(board.getCellByCoordinates(2,1).getPossibleValues());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        //then
        assertFalse(possibleValues.contains(1));
        assertFalse(possibleValues.contains(2));
        assertTrue(possibleValues.contains(3));
    }

    @Test
    void fillCellWithOnePossibleValue(){
        //given
        Board board = new Board();
        Solver solver = new Solver();

        try {
            board.getCellByCoordinates(1,1).setValue(1);
            board.getCellByCoordinates(1,2).setValue(2);
            board.getCellByCoordinates(1,3).setValue(3);
            board.getCellByCoordinates(1,4).setValue(4);
            board.getCellByCoordinates(1,5).setValue(5);
            board.getCellByCoordinates(1,6).setValue(6);
            board.getCellByCoordinates(1,7).setValue(7);
            board.getCellByCoordinates(1,8).setValue(8);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        board.drawBoard();
        //when
        solver.updatePossibleValues(board);
        solver.fillCellWithOnePossibleValue(board);

        int missingValue=0;
        try {
            missingValue = board.getCellByCoordinates(1,0).getValue();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(9,missingValue);
    }

    @Test
    void solvingLoop(){
        //given
        Board board = new Board();
        Solver solver = new Solver();

        try {
            //row1
            //board.getCellByCoordinates(0,0).setValue(4);
            board.getCellByCoordinates(1,0).setValue(2);
            //board.getCellByCoordinates(2,0).setValue(6);
            board.getCellByCoordinates(3,0).setValue(5);
            //board.getCellByCoordinates(4,0).setValue(7);
            board.getCellByCoordinates(5,0).setValue(1);
            //board.getCellByCoordinates(6,0).setValue(3);
            board.getCellByCoordinates(7,0).setValue(9);
            //board.getCellByCoordinates(8,0).setValue(8);

            //row2
            board.getCellByCoordinates(0,1).setValue(8);
            //board.getCellByCoordinates(1,1).setValue(5);
            //board.getCellByCoordinates(2,1).setValue(7);
            board.getCellByCoordinates(3,1).setValue(2);
            //board.getCellByCoordinates(4,1).setValue(9);
            board.getCellByCoordinates(5,1).setValue(3);
            //board.getCellByCoordinates(6,1).setValue(1);
            //board.getCellByCoordinates(7,1).setValue(4);
            board.getCellByCoordinates(8,1).setValue(6);


            //row3
            //board.getCellByCoordinates(0,2).setValue(1);
            board.getCellByCoordinates(1,2).setValue(3);
            //board.getCellByCoordinates(2,2).setValue(9);
            //board.getCellByCoordinates(3,2).setValue(4);
            board.getCellByCoordinates(4,2).setValue(6);
            // board.getCellByCoordinates(5,2).setValue(8);
            //board.getCellByCoordinates(6,2).setValue(2);
            board.getCellByCoordinates(7,2).setValue(7);
            //board.getCellByCoordinates(8,2).setValue(5);


            //row4
            //board.getCellByCoordinates(0,3).setValue(9);
            //board.getCellByCoordinates(1,3).setValue(7);
            board.getCellByCoordinates(2,3).setValue(1);
            //board.getCellByCoordinates(3,3).setValue(3);
            //board.getCellByCoordinates(4,3).setValue(8);
            //board.getCellByCoordinates(5,3).setValue(5);
            board.getCellByCoordinates(6,3).setValue(6);
            //board.getCellByCoordinates(7,3).setValue(2);
            //board.getCellByCoordinates(8,3).setValue(4);


            //row5
            board.getCellByCoordinates(0,4).setValue(5);
            board.getCellByCoordinates(1,4).setValue(4);
            //board.getCellByCoordinates(2,4).setValue(3);
            //board.getCellByCoordinates(3,4).setValue(7);
            //board.getCellByCoordinates(4,4).setValue(2);
            //board.getCellByCoordinates(5,4).setValue(6);
            //board.getCellByCoordinates(6,4).setValue(8);
            board.getCellByCoordinates(7,4).setValue(1);
            board.getCellByCoordinates(8,4).setValue(9);


            //row6
            //board.getCellByCoordinates(0,5).setValue(6);
            //board.getCellByCoordinates(1,5).setValue(8);
            board.getCellByCoordinates(2,5).setValue(2);
            //board.getCellByCoordinates(3,5).setValue(1);
            //board.getCellByCoordinates(4,5).setValue(4);
            //board.getCellByCoordinates(5,5).setValue(9);
            board.getCellByCoordinates(6,5).setValue(7);
            //board.getCellByCoordinates(7,5).setValue(5);
            //board.getCellByCoordinates(8,5).setValue(3);


            //row7
            //board.getCellByCoordinates(0,6).setValue(7);
            board.getCellByCoordinates(1,6).setValue(9);
            //board.getCellByCoordinates(2,6).setValue(4);
            //board.getCellByCoordinates(3,6).setValue(6);
            board.getCellByCoordinates(4,6).setValue(3);
            //board.getCellByCoordinates(5,6).setValue(2);
            //board.getCellByCoordinates(6,6).setValue(5);
            board.getCellByCoordinates(7,6).setValue(8);
            //board.getCellByCoordinates(8,6).setValue(1);


            //row8
            board.getCellByCoordinates(0,7).setValue(2);
            //board.getCellByCoordinates(1,7).setValue(6);
            //board.getCellByCoordinates(2,7).setValue(5);
            board.getCellByCoordinates(3,7).setValue(8);
            //board.getCellByCoordinates(4,7).setValue(1);
            board.getCellByCoordinates(5,7).setValue(4);
            //board.getCellByCoordinates(6,7).setValue(9);
            //board.getCellByCoordinates(7,7).setValue(3);
            board.getCellByCoordinates(8,7).setValue(7);


            //row9
            //board.getCellByCoordinates(0,8).setValue(3);
            board.getCellByCoordinates(1,8).setValue(1);
            //board.getCellByCoordinates(2,8).setValue(8);
            board.getCellByCoordinates(3,8).setValue(9);
            //board.getCellByCoordinates(4,8).setValue(5);
            board.getCellByCoordinates(5,8).setValue(7);
            //board.getCellByCoordinates(6,8).setValue(4);
            board.getCellByCoordinates(7,8).setValue(6);
            //board.getCellByCoordinates(8,8).setValue(2);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        board.drawBoard();
        solver.solve(board);





    }

}
