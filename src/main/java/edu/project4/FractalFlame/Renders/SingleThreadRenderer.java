package edu.project4.FractalFlame.Renders;

import edu.project4.Constants;
import edu.project4.FractalFlame.Generators.AffineGenerator;
import edu.project4.FractalFlame.Generators.Generator;
import edu.project4.FractalFlame.Image.ImageClasses.FractalImage;
import edu.project4.FractalFlame.RecordClasses.Rect;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import edu.project4.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.List;

public class SingleThreadRenderer implements Renderer {
    @Override
    public FractalImage render(
        List<Transformation> variations
    ) {
        FractalImage fractalImage = FractalImage.create(Constants.WIDTH, Constants.HEIGHT);
        Generator<AffineTransformation> affineTransformationGenerator = new AffineGenerator();
        List<AffineTransformation> affineTransformationList = affineTransformationGenerator.generate();
        for (long i = 0; i < Constants.COUNT_SAMPLES; ++i) {
            RenderUtils.renderOneSample(
                fractalImage,
                new Rect(Constants.RECT_X, Constants.RECT_Y, Constants.RECT_WIDTH, Constants.RECT_HEIGHT),
                affineTransformationList,
                variations
            );
        }
        return fractalImage;
    }
}
