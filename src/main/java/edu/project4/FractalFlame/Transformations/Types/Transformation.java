package edu.project4.FractalFlame.Transformations.Types;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.function.Function;

public interface Transformation extends Function<Coordinate, Coordinate> {
    void setAffine(AffineTransformation affineTransformation);
}
