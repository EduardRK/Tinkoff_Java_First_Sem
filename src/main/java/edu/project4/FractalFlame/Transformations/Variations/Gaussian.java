package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class Gaussian implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double psi5 = threadLocalRandom.nextDouble(-1, 1);
        double twoPiPsi5 = 2 * Math.PI * psi5;

        double sum = 0;
        for (int i = 0; i < 4; ++i) {
            double psi = threadLocalRandom.nextDouble(-1, 1);
            sum += (psi - 2);
        }

        return new Coordinate(
            sum * Math.cos(twoPiPsi5),
            sum * Math.sin(twoPiPsi5)
        );
    }
}
