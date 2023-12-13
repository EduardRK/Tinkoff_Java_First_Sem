package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Power implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double sinTheta = Math.sin(theta);
        double power = Math.pow(r, sinTheta);
        return new Coordinate(
            power * Math.cos(theta),
            power * sinTheta
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
