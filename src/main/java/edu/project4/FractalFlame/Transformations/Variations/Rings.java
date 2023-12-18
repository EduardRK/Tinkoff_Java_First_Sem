package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Rings implements Transformation {
    private AffineTransformation affineTransformation;

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double cSquare = Math.pow(affineTransformation.c(), 2);
        double multiplier = (r + cSquare % (2 * cSquare) - cSquare + r * (1 - cSquare));
        return new Coordinate(
            multiplier * Math.cos(theta),
            multiplier * Math.sin(theta)
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {
        this.affineTransformation = affineTransformation;
    }
}
