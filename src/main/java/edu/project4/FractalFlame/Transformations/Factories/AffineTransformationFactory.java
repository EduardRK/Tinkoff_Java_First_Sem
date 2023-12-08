package edu.project4.FractalFlame.Transformations.Factories;

import edu.project4.Constants;
import edu.project4.FractalFlame.Transformations.Variations.AffineTransformation;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class AffineTransformationFactory {
    private static final int MAX_COLOR = 255;

    public AffineTransformationFactory() {
    }

    public AffineTransformation create() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        while (true) {
            double a = threadLocalRandom.nextDouble(Constants.A_AFFINE_MIN, Constants.A_AFFINE_MAX);
            double b = threadLocalRandom.nextDouble(Constants.B_AFFINE_MIN, Constants.B_AFFINE_MAX);
            double c = threadLocalRandom.nextDouble(Constants.C_AFFINE_MIN, Constants.C_AFFINE_MAX);
            double d = threadLocalRandom.nextDouble(Constants.D_AFFINE_MIN, Constants.D_AFFINE_MAX);
            double e = threadLocalRandom.nextDouble(Constants.E_AFFINE_MIN, Constants.E_AFFINE_MAX);
            double f = threadLocalRandom.nextDouble(Constants.F_AFFINE_MIN, Constants.F_AFFINE_MAX);

            if (isValidAffineTransformation(a, b, c, d, e, f)) {
                return new AffineTransformation(a, b, c, d, e, f, new Color(
                    threadLocalRandom.nextInt(MAX_COLOR),
                    threadLocalRandom.nextInt(MAX_COLOR),
                    threadLocalRandom.nextInt(MAX_COLOR)
                ));
            }
        }
    }

    private boolean isValidAffineTransformation(double a, double b, double c, double d, double e, double f) {
        return Math.pow(a, 2) + Math.pow(d, 2) < 1
            && Math.pow(b, 2) + Math.pow(e, 2) < 1
            && Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(d, 2) + Math.pow(e, 2) < (1 + Math.pow((a * e - b * d), 2));
    }
}
