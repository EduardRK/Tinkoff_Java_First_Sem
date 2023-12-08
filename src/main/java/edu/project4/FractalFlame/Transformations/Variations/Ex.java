package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

@SuppressWarnings("MagicNumber")
public class Ex implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double p0 = Math.signum(theta + r);
        double p0Cube = Math.pow(p0, 3);
        double p1 = Math.cos(theta - r);
        double p1Cube = Math.pow(p1, 3);
        return new Coordinate(
            r * (p0Cube + p1Cube),
            r * (p0Cube - p1Cube)
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
