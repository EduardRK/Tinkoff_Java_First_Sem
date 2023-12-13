package edu.project4.FractalFlame.RecordClasses;

import org.jetbrains.annotations.NotNull;

public record Rect(double x, double y, double width, double height) {
    public boolean contains(@NotNull Coordinate coordinate) {
        return coordinate.x() >= x && coordinate.x() <= x + width
            && coordinate.y() >= y && coordinate.y() <= y + height;
    }

    public double getMaxX() {
        return x + width;
    }

    public double getMaxY() {
        return y + height;
    }
}
