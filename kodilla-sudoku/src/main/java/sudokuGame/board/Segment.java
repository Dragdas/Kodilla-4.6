package sudokuGame.board;

import java.util.ArrayList;
import java.util.List;

public class Segment {
    private List<Cell> cells = new ArrayList<>();
    private Coordinates topLeftCoordinates;


    public Segment(Coordinates topLeftCoordinates) {
        this.topLeftCoordinates = topLeftCoordinates;
        initialize(topLeftCoordinates.getColumn(), topLeftCoordinates.getRow());
    }

    private void initialize(int startingColumn, int startingRow){
        for(int rowsCreationCounter = 0; rowsCreationCounter < 3 ; rowsCreationCounter++ ){
            for(int columnCreationCounter = 0; columnCreationCounter < 3; columnCreationCounter++  ){
                cells.add(new Cell(new Coordinates(startingColumn + columnCreationCounter, startingRow + rowsCreationCounter), this));
            }
        }

    }




    public List<Cell> getCells() {
        return cells;
    }

}
