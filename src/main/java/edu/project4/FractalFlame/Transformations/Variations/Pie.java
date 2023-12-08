package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class Pie implements Parametric {
    private double slices = 4;
    private double rotation = Math.PI / 6;
    private double thickness = 10;
    private double twoPiOverSlices = 2 * Math.PI / slices;

    @Override
    public void setParameters(List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            slices = iterator.next();
            twoPiOverSlices = 2 * Math.PI / slices;
        }
        if (iterator.hasNext()) {
            rotation = iterator.next();
        }
        if (iterator.hasNext()) {
            thickness = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double psi1 = threadLocalRandom.nextDouble(-1, 1);
        double psi2 = threadLocalRandom.nextDouble(-1, 1);
        double psi3 = threadLocalRandom.nextDouble(-1, 1);
        double t1 = (int) (psi1 + 0.5);
        double t2 = (int) (rotation + twoPiOverSlices * (t1 + psi2 * thickness));
        return new Coordinate(
            psi3 * Math.cos(t2),
            psi3 * Math.sin(t2)
        );
    }
}
