package sudokuGame.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segment)) return false;
        Segment segment = (Segment) o;
        return Objects.equals(getCells(), segment.getCells()) && Objects.equals(topLeftCoordinates, segment.topLeftCoordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCells(), topLeftCoordinates);
    }

    public List<Cell> getCells() {
        return cells;
    }

}
