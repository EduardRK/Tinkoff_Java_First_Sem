package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Eyefish implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double multiplier = 2 / (1 + r);
        return new Coordinate(
            multiplier * coordinate.x(),
            multiplier * coordinate.y()
        );
    }
}
