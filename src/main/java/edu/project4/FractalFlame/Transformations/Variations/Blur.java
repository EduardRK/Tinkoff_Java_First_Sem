package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.util.concurrent.ThreadLocalRandom;

public class Blur implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double psi1 = threadLocalRandom.nextDouble(-1, 1);
        double psi2 = threadLocalRandom.nextDouble(-1, 1);
        double twoPiPsi2 = 2 * Math.PI * psi2;
        return new Coordinate(
            psi1 * Math.cos(twoPiPsi2),
            psi1 * Math.sin(twoPiPsi2)
        );
    }
}
