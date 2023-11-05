package edu.project2;

public class Cell {
    private final int row;
    private final int col;
    private Type type;

    public enum Type {
        PASSAGE,
        WALL
    }

    public Cell(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public int col() {
        return col;
    }

    public int row() {
        return row;
    }

    public boolean isWall() {
        return (this.type == Type.WALL);
    }

    public boolean isPassage() {
        return (this.type == Type.PASSAGE);
    }

    public void createPassage() {
        this.type = Type.PASSAGE;
    }

    public static Cell createWall(int row, int col) {
        return new Cell(row, col, Type.WALL);
    }
}
