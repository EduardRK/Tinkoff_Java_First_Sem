package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Linear implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        return new Coordinate(coordinate.x(), coordinate.y());
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
