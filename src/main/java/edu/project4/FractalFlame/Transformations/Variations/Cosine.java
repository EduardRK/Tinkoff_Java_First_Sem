package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Cosine implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double piX = Math.PI * coordinate.x();
        return new Coordinate(
            Math.cos(piX) * Math.cosh(coordinate.y()),
            -Math.sin(piX) * Math.sinh(coordinate.y())
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
