package edu.project4.FractalFlame.RecordClasses;

public record Coordinate(double x, double y) {
    public Coordinate rotate(double angle) {
        return new Coordinate(
            this.x * Math.cos(angle) - this.y * Math.sin(angle),
            this.x * Math.sin(angle) + this.y * Math.cos(angle)
        );
    }
}
