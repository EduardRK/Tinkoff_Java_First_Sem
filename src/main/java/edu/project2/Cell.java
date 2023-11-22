package edu.project2;

public final class Cell {
    private final int row;
    private final int col;
    private Type type;

    public Cell(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public static Cell createWall(int row, int col) {
        return new Cell(row, col, Type.WALL);
    }

    public int col() {
        return col;
    }

    public int row() {
        return row;
    }

    public boolean isWall() {
        return type == Type.WALL;
    }

    public boolean isPassage() {
        return type == Type.PASSAGE;
    }

    public void createPassage() {
        type = Type.PASSAGE;
    }

    public enum Type {
        PASSAGE,
        WALL
    }
}
