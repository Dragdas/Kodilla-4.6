package userInputValidationTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sudokuGame.board.Board;
import sudokuGame.board.Coordinates;
import sudokuGame.board.WrongCoordinatesException;
import sudokuGame.gui.UserInputValidator;

import static org.junit.jupiter.api.Assertions.*;

public class UserInputValidatorTestSuit {

    @Test
    void userInputValidation(){
        //given
        UserInputValidator validator = new UserInputValidator();
        String validInput = "5,3,7";
        String wrongParamsCount = "1,5";
        String wrongValue = "5,6,10";
        String text = "sa";

        //when
        boolean validTest           = validator.isInitialValueInputValid(validInput);
        boolean wrongParamCountTest = validator.isInitialValueInputValid(wrongParamsCount);
        boolean wrongValueTest      = validator.isInitialValueInputValid(wrongValue);
        boolean textTest = validator.isInitialValueInputValid(text);

        //then
        assertTrue(validTest);
        assertFalse(wrongParamCountTest);
        assertFalse(wrongValueTest);
        assertFalse(textTest);

    }

    @Test
    void boardValidationEmpty(){
        //given
        Board boardEmpty = new Board();

        //when
        boolean result = UserInputValidator.isBoardStateValid(boardEmpty);

        //then
        assertTrue(result);


    }

    @Test
    void boardValidationWrongRow(){
        //given
        Board boardWrongRow = new Board();
        Coordinates coordinates1 = new Coordinates(1,1);
        Coordinates coordinates2 = new Coordinates(1,6);

        //when
        try {
            boardWrongRow.getCellByCoordinates(coordinates1).setValue(1);
            boardWrongRow.getCellByCoordinates(coordinates2).setValue(1);
        }catch (WrongCoordinatesException e){
            System.out.println("Wrong coordinates exception in boardValidationWrongRow method");
        }

        boolean result = UserInputValidator.isBoardStateValid(boardWrongRow);

        //then
        assertFalse(result);
    }

    @Test
    void boardValidationWrongSegment(){
        //given
        Board boardWrongSegment = new Board();
        Coordinates coordinates1 = new Coordinates(1,1);
        Coordinates coordinates2 = new Coordinates(2,2);

        //when
        try {
            boardWrongSegment.getCellByCoordinates(coordinates1).setValue(1);
            boardWrongSegment.getCellByCoordinates(coordinates2).setValue(1);
        }catch (WrongCoordinatesException e){
            System.out.println("Wrong coordinates exception in boardValidationWrongSegment method");
        }

        boolean result = UserInputValidator.isBoardStateValid(boardWrongSegment);

        //then
        assertFalse(result);
    }

    @Test
    void boardValidationWrongColumn(){
        //given
        Board boardWrongColumn = new Board();
        Coordinates coordinates1 = new Coordinates(1,1);
        Coordinates coordinates2 = new Coordinates(6,1);

        //when
        try {
            boardWrongColumn.getCellByCoordinates(coordinates1).setValue(1);
            boardWrongColumn.getCellByCoordinates(coordinates2).setValue(1);
        }catch (WrongCoordinatesException e){
            System.out.println("Wrong coordinates exception in boardValidationWrongRow method");
        }

        boolean result = UserInputValidator.isBoardStateValid(boardWrongColumn);

        //then
        assertFalse(result);
    }

    @Test
    void boardValidationValidBoard(){
        //given
        Board boardValid = new Board();
        Coordinates coordinates1 = new Coordinates(1,1);
        Coordinates coordinates2 = new Coordinates(6,1);
        Coordinates coordinates3 = new Coordinates(1,5);
        Coordinates coordinates4 = new Coordinates(1,2);

        //when
        try {
            boardValid.getCellByCoordinates(coordinates1).setValue(1);
            boardValid.getCellByCoordinates(coordinates2).setValue(3);
            boardValid.getCellByCoordinates(coordinates3).setValue(3);
            boardValid.getCellByCoordinates(coordinates4).setValue(2);
        }catch (WrongCoordinatesException e){
            System.out.println("Wrong coordinates exception in boardValidationWrongRow method");
        }

        boolean result = UserInputValidator.isBoardStateValid(boardValid);

        //then
        assertTrue(result);
    }




}
