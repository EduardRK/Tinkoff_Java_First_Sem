package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class Square implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double psi1 = threadLocalRandom.nextDouble(-1, 1);
        double psi2 = threadLocalRandom.nextDouble(-1, 1);
        return new Coordinate(
            psi1 - 0.5,
            psi2 - 0.5
        );
    }
}
