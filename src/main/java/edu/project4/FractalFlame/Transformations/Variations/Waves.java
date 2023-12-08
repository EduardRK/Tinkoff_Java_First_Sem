package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;

public class Waves implements Transformation {
    private AffineTransformation affineTransformation;

    @Override
    public Coordinate apply(Coordinate coordinate) {
        return new Coordinate(
            coordinate.x()
                + affineTransformation.b() * Math.sin(coordinate.y() / Math.pow(affineTransformation.c(), 2)),
            coordinate.y()
                + affineTransformation.e() * Math.sin(coordinate.x() / Math.pow(affineTransformation.f(), 2))
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {
        this.affineTransformation = affineTransformation;
    }
}
