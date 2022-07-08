package sudokuGame.gui;

import sudokuGame.board.Board;
import sudokuGame.board.Coordinates;
import sudokuGame.board.WrongCoordinatesException;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner userInput = new Scanner(System.in);
    UserInputValidator validator = new UserInputValidator();

    Board board;

    public UserInterface(Board board) {
        this.board = board;
    }

    public void greet(){
        System.out.println("Welcome to sudoku solver");
        System.out.println("You will be asked to provide initial game values");
        System.out.println("Please use following convention:");
        System.out.println("C,R,V");
        System.out.println("C- column, R- row, V- value");
        System.out.println("Press enter to continue");
        userInput.nextLine();
    }

    public void askForInitialValues(){
        while (true){
            board.drawBoard();
            System.out.println("Please provide initial value in mentioned convention C,R,V");
            System.out.println("Or write SUDOKU to solve provided problem");
            String answer = userInput.nextLine();

            if(answer.equals("SUDOKU"))
                break;
            else {
                if(!validator.isInitialValueInputValid(answer)){
                    System.out.println("Provided input was invalid");
                    System.out.println("Press enter to continue");
                    userInput.nextLine();
                    continue;
                }
                List<Integer> values = Arrays.stream(answer.split(",")).toList().stream()
                                        .map(Integer::valueOf)
                                        .toList();

                Coordinates usersCoordinates = new Coordinates(values.get(0)-1, values.get(1)-1);
                int usersValue = values.get(2);

                try {
                    board.getCellByCoordinates(usersCoordinates).setValue(usersValue);
                }catch (WrongCoordinatesException e){
                    System.out.println("Wrong coordinates exception in askForInitialValues method");
                }


            }
        }




    }


}
