package edu.project4.FractalFlame.Renders;

import edu.project4.Constants;
import edu.project4.FractalFlame.Image.ImageClasses.FractalImage;
import edu.project4.FractalFlame.Image.ImageClasses.Pixel;
import edu.project4.FractalFlame.RecordClasses.Coordinate;
import edu.project4.FractalFlame.RecordClasses.Rect;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import edu.project4.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class RenderUtils {

    private RenderUtils() {
    }

    public static void renderOneSample(
        FractalImage fractalImage,
        Rect rect,
        List<AffineTransformation> affineTransformationList,
        List<Transformation> variations
    ) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Coordinate coordinate = getRandomCoordinate(rect, threadLocalRandom);

        for (int i = -Constants.ITERATIONS_FOR_CENTER; i < Constants.COUNT_ONE_SAMPLE; ++i) {
            AffineTransformation affineTransformation =
                getRandomAffineTransformation(affineTransformationList, threadLocalRandom);
            Transformation transformation = getRandomVariation(variations, threadLocalRandom);
            coordinate = affineTransformation.apply(coordinate);
            transformation.setAffine(affineTransformation);
            coordinate = transformation.apply(coordinate);

            if (i > 0) {
                double angle = 0.0;
                for (int s = 0; s < Constants.SYMMETRY; angle += 2 * Math.PI / Constants.SYMMETRY, ++s) {
                    coordinate = coordinate.rotate(angle);
                    if (rect.contains(coordinate)) {
                        Coordinate newCoordinate = getNewCoordinate(coordinate, rect);
                        if (newCoordinate.x() < Constants.WIDTH && newCoordinate.y() < Constants.HEIGHT) {
                            Pixel pixel = fractalImage.pixel(newCoordinate);
                            synchronized (pixel) {
                                pixel.setColor(affineTransformation);
                                pixel.hit();
                            }
                        }
                    }
                }

            }
        }
    }

    private static AffineTransformation getRandomAffineTransformation(
        List<AffineTransformation> affineTransformationList,
        ThreadLocalRandom threadLocalRandom
    ) {
        return affineTransformationList.get(threadLocalRandom.nextInt(affineTransformationList.size()));
    }

    private static Transformation getRandomVariation(
        List<Transformation> variations,
        ThreadLocalRandom threadLocalRandom
    ) {
        return variations.get(threadLocalRandom.nextInt(variations.size()));
    }

    private static Coordinate getRandomCoordinate(Rect rect, ThreadLocalRandom threadLocalRandom) {
        return new Coordinate(
            rect.x() + threadLocalRandom.nextDouble(0, 1) * rect.width(),
            rect.y() + threadLocalRandom.nextDouble(0, 1) * rect.height()
        );
    }

    private static Coordinate getNewCoordinate(Coordinate coordinate, Rect rect) {
        return new Coordinate(
            Constants.WIDTH
                - (int) (((rect.getMaxX() - coordinate.x()) / (rect.getMaxX() - rect.x())) * Constants.WIDTH),
            Constants.HEIGHT
                - (int) (((rect.getMaxY() - coordinate.y()) / (rect.getMaxY() - rect.y())) * Constants.HEIGHT)
        );
    }
}
