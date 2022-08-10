package sudokuGame.board;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<Cell> cells = new ArrayList<>();
    private List<Segment> segments = new ArrayList<>();

    public Board() {

        segments.addAll(List.of(
                new Segment(new Coordinates(0,0)),
                new Segment(new Coordinates(0,3)),
                new Segment(new Coordinates(0,6)),
                new Segment(new Coordinates(3,0)),
                new Segment(new Coordinates(3,3)),
                new Segment(new Coordinates(3,6)),
                new Segment(new Coordinates(6,0)),
                new Segment(new Coordinates(6,3)),
                new Segment(new Coordinates(6,6))
        ));

        cells.addAll(segments.stream().flatMap(segment -> segment.getCells().stream()).toList());
    }

    public void drawBoard(){
        cleanConsole();
        drawHeader();
        drawRows();

    }

    private void cleanConsole() {
        for (int i = 0; i<9 ; i++){
            System.out.println();
        }
    }

    private void drawRows() {
        for (int i = 0; i<9 ; i++){
            drawRow(i);
        }
    }

    private void drawHeader(){
        System.out.println( "   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |"   );
        System.out.println( "---|---|---|---|---|---|---|---|---|---|");
    }

    private void drawRow(int rowNo){
        List<Integer> values = getRowValues(rowNo);

        StringBuilder rowString = new StringBuilder(String.format(" %d | ", rowNo + 1));

        for(Integer value : values){
            String toAppend = value!=0? value + " | " : "  | ";
            rowString.append(toAppend);
        }

        System.out.println(rowString);
        System.out.println( "---|---|---|---|---|---|---|---|---|---|");
    }

    private List<Integer> getRowValues(int rowNo) {
        return cells.stream().filter(cell -> cell.getRow()== rowNo)
                            .sorted(Comparator.comparing(Cell::getColumn))
                            .map(Cell::getValue)
                            .toList();
    }

    public Cell getCellByCoordinates(Coordinates coordinates) throws WrongCoordinatesException {

        List<Cell> cellList = cells.stream().filter(cell -> cell.getCoordinates().equals(coordinates)).toList();

        if(cellList.size()==1)
            return cellList.get(0);
        else throw new WrongCoordinatesException();

    }

    public Cell getCellByCoordinates(int column, int row) throws WrongCoordinatesException {

        List<Cell> cellList = cells.stream().filter(cell -> cell.getColumn()==column && cell.getRow()==row ).toList();

        if(cellList.size()==1)
            return cellList.get(0);
        else throw new WrongCoordinatesException();

    }



    public List<Cell> getCells() {
        return cells;
    }

    public List<Segment> getSegments() {
        return segments;
    }
}
