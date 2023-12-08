package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class JuliaN implements Parametric {
    private double power = 2;
    private double dist = 5;
    private double p3;
    private double twoPiP3;
    private double distOverPower;

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(Coordinate coordinate) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double phi = Math.atan(coordinate.y() / coordinate.x());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        double t = (phi + twoPiP3) / power;
        double multiplier = Math.pow(r, distOverPower);
        return new Coordinate(
            multiplier * Math.cos(t),
            multiplier * Math.sin(t)
        );
    }

    @Override
    public void setParameters(List<Double> parameters) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double psi = threadLocalRandom.nextDouble(-1, 1);

        p3 = (int) (Math.abs(power) * psi);
        twoPiP3 = 2 * Math.PI * p3;
        distOverPower = dist / power;

        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            power = iterator.next();
        }
        if (iterator.hasNext()) {
            dist = iterator.next();
        }
    }
}
