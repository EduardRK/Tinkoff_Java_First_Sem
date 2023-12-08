package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.util.concurrent.ThreadLocalRandom;

public class Julia implements Transformation {
    @Override
    public Coordinate apply(Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double rSqrt = Math.sqrt(Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2)));
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double omega = threadLocalRandom.nextDouble(0, Math.PI);
        return new Coordinate(
            rSqrt * Math.cos(theta / 2 + omega),
            rSqrt * Math.sin(theta / 2 + omega)
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
