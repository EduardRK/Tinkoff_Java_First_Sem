package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Spiral implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double multiplier = 1 / r;
        return new Coordinate(
            multiplier * (Math.cos(theta) + Math.sin(r)),
            multiplier * (Math.sin(theta) - Math.cos(r))
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
