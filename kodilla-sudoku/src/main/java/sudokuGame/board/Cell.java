package sudokuGame.board;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Coordinates coordinates;
    private Segment segment;
    private int value;
    private boolean isEmpty;
    private List<Integer>possibleValues = new ArrayList<>();

    public Cell(Coordinates coordinates, Segment segment) {
        this.coordinates = coordinates;
        this.segment = segment;
        isEmpty = true;
        value = 0;
        possibleValues.addAll(List.of(1,2,3,4,5,6,7,8,9));
    }

    public void setValue(int value) {
        this.value = value;
        isEmpty = false;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + coordinates.getRow() +
                ", column=" + coordinates.getColumn() +
                ", value=" + value +
                '}';
    }



    public int getRow() {
        return coordinates.getRow();
    }

    public int getColumn() {
        return coordinates.getColumn();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getValue() {
        return value;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }
}
