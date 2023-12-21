package edu.project2;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Cell {
    private final int row;
    private final int col;
    private Type type;

    public Cell(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Cell createWall(int row, int col) {
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
