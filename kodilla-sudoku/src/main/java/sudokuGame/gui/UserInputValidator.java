package sudokuGame.gui;

import sudokuGame.board.Board;
import sudokuGame.board.Cell;
import sudokuGame.board.Segment;

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

    public static boolean isBoardStateValid(Board board){
        List<Cell> cells = board.getCells();

        if (!areRowsValid(cells)) return false;

        if (!areColumnsValid(cells))return false;

        if(!areSegmentsValid(board.getSegments()))return false;

        return true;
    }


    private static boolean areSegmentsValid(List<Segment> segments){

        for (Segment s: segments ) {
            if(!isSegmentValid(s))
                return false;
        }

        return true;
    }

    private static boolean isSegmentValid(Segment segment){
        return !isThereDuplicatedValue(segment.getCells());
    }

    private static boolean areColumnsValid(List<Cell> cells) {
        for(int i = 0; i < 10; i++){
            if(!isColumnValid(cells,i))
                return false;
        }
        return true;
    }


    private static boolean isColumnValid(List<Cell> cells, int column){
        List<Cell> cellsFromColumn = cells.stream().filter(cell -> cell.getColumn() == column).toList();

        return !isThereDuplicatedValue(cellsFromColumn);
    }

    private static boolean isThereDuplicatedValue(List<Cell> cells) {
        for (int i = 1; i < 10 ; i++){
            int tempIterator = i;
            long sameValuesCount = cells.stream().filter(cell -> cell.getValue() == tempIterator).count();
            if(sameValuesCount > 1 )
                return true;
        }
        return false;
    }


    private static boolean areRowsValid(List<Cell> cells) {
        for(int i = 0; i < 10; i++){
            if(!isRowValid(cells,i))
                return false;
        }
        return true;
    }

    private static boolean isRowValid(List<Cell> cells, int row){
        List<Cell> cellsFromRow = cells.stream().filter(cell -> cell.getRow()==row).toList();

        return !isThereDuplicatedValue(cellsFromRow);
    }


}
