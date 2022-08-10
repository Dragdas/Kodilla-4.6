package sudokuGame.solver;

import sudokuGame.board.Board;
import sudokuGame.board.Cell;
import sudokuGame.board.Segment;

import java.util.List;

public class Solver {

    public void solve(Board board){
        boolean madeProgress;

        do {
            madeProgress = false;
            long possibleMovesBeforeLoop = board.getCells().stream().flatMap(cell -> cell.getPossibleValues().stream()).count();

            updatePossibleValues(board);
            fillCellWithOnePossibleValue(board);

            long possibleMoves = board.getCells().stream().flatMap(cell -> cell.getPossibleValues().stream()).count();

            if(possibleMoves<possibleMovesBeforeLoop)
                madeProgress = true;

            //TODO delete
            board.drawBoard();
        }while (madeProgress);

        System.out.println("Solved");
    }


    public void fillCellWithOnePossibleValue(Board board){
        board.getCells().stream().filter(cell -> cell.getPossibleValues().size()==1 )
                .forEach(cell -> cell.setValue(cell.getPossibleValues().get(0)));
        }

    public void updatePossibleValues(Board board){

        board.getCells().stream().filter(Cell::isEmpty).
                forEach(cell -> {
                    cell.getPossibleValues().removeAll(valuesInRow(cell.getRow(), board));
                    cell.getPossibleValues().removeAll(valuesInColumn(cell.getColumn(),board));
                    cell.getPossibleValues().removeAll(valuesInSegment(cell.getSegment(),board));
                });

    }


    private List<Integer> valuesInRow(int row, Board board){
        return board.getCells().stream().filter(cell -> cell.getRow() == row && !cell.isEmpty())
                .map(Cell::getValue)
                .toList();
    }

    private List<Integer> valuesInColumn(int column, Board board){
        return board.getCells().stream().filter(cell -> cell.getColumn() == column && !cell.isEmpty())
                .map(Cell::getValue)
                .toList();
    }

    private List<Integer> valuesInSegment(Segment segment, Board board){
        return board.getCells().stream().filter(cell -> cell.getSegment().equals(segment) && !cell.isEmpty())
                .map(Cell::getValue)
                .toList();
    }



}
