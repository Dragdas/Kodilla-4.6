package sudokuGame.game;

import sudokuGame.board.Board;
import sudokuGame.gui.UserInterface;

public class GameManager {

    Board board;
    UserInterface ui;

    public GameManager() {
        board = new Board();
        ui = new UserInterface(board);
    }

    public void play(){
        ui.greet();
        ui.askForInitialValues();


    }


}
