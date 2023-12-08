package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Exponential implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double exp = Math.exp(coordinate.x() - 1);
        double piY = Math.PI * coordinate.y();
        return new Coordinate(
            exp * Math.cos(piY),
            exp * Math.sin(piY)
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
