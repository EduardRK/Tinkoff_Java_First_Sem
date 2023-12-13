package edu.project4.FractalFlame.RecordClasses;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Coordinate(double x, double y) {
    @Contract("_ -> new")
    public @NotNull Coordinate rotate(double angle) {
        return new Coordinate(
            this.x * Math.cos(angle) - this.y * Math.sin(angle),
            this.x * Math.sin(angle) + this.y * Math.cos(angle)
        );
    }
}
