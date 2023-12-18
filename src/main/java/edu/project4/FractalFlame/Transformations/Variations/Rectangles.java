package edu.project4.FractalFlame.Transformations.Variations;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Rectangles implements Parametric {
    private double x = 1;
    private double y = 1;

    @Override
    public void setParameters(@NotNull List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            x = iterator.next();
        }
        if (iterator.hasNext()) {
            y = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        return new Coordinate(
            (2 * Math.floor(coordinate.x() / x) + 1) * x - coordinate.x(),
            (2 * Math.floor(coordinate.y() / y) + 1) * y - coordinate.y()
        );
    }
}
