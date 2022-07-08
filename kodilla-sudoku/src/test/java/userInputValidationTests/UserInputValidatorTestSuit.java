package userInputValidationTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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



}
