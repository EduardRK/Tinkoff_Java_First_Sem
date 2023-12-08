package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Tangent implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        return new Coordinate(
            Math.sin(coordinate.x()) / Math.cos(coordinate.y()),
            Math.tan(coordinate.y())
        );
    }
}
