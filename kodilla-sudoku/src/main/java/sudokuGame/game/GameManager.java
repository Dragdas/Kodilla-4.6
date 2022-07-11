package sudokuGame.game;

import sudokuGame.board.Board;
import sudokuGame.gui.UserInputValidator;
import sudokuGame.gui.UserInterface;

public class GameManager {

    Board board;
    UserInterface ui;

    public GameManager() {
        board = new Board();
        ui = new UserInterface(board);
    }

    public void play(){

        while (true){
            board = new Board();
            ui.greet();
            ui.askForInitialValues();
            if(UserInputValidator.isBoardStateValid(board))
                break;
            ui.invalidInitialValuesNotification();
        }






    }


}
