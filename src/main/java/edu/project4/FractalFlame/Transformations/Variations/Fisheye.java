package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Fisheye implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double multiplier = 2 / (r + 1);
        return new Coordinate(
            multiplier * coordinate.y(),
            multiplier * coordinate.x()
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
