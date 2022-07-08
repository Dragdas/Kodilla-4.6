package sudokuGame.gui;

import java.util.Arrays;
import java.util.List;

public class UserInputValidator {

    public boolean isInitialValueInputValid(String input){
        List<String> strings = Arrays.stream(input.split(",")).toList();

        if(strings.size() != 3)
            return false;

        try {
            long countOfValidValues = strings.stream().map(Integer::valueOf)
                    .filter(integer -> integer > 0 && integer < 10)
                    .count();

            return countOfValidValues == 3;

        }catch (Exception e){
            return false;
        }
    }



}
