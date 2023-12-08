package edu.project4.FractalFlame.Generators;

import edu.project4.Constants;
import edu.project4.FractalFlame.Image.ImageClasses.FractalImage;
import edu.project4.FractalFlame.Image.ImageClasses.ImageFormat;
import edu.project4.FractalFlame.Image.ImageSaver;
import edu.project4.FractalFlame.Image.Processors.GammaCorrection;
import edu.project4.FractalFlame.Image.Processors.ImageProcessor;
import edu.project4.FractalFlame.Renders.MultiThreadRenderer;
import edu.project4.FractalFlame.Renders.Renderer;
import edu.project4.FractalFlame.Transformations.Types.Transformation;
import java.nio.file.Path;
import java.util.List;

public final class FractalFlameGenerator {
    private FractalFlameGenerator() {

    }

    public static void generate(List<String> variations, ImageFormat imageFormat, List<Double> parameters, Path path) {
        Generator<Transformation> transformationGenerator = new TransformationGenerator(variations, parameters);
        List<Transformation> variationList = transformationGenerator.generate();

        Renderer renderer = new MultiThreadRenderer();
        FractalImage fractalImage =
            renderer.render(variationList);

        ImageProcessor imageProcessor = new GammaCorrection();
        imageProcessor.process(fractalImage);

        ImageSaver.save(fractalImage, imageFormat, path);
    }

    public static void generate(List<String> variations, ImageFormat imageFormat, List<Double> parameters) {
        generate(variations, imageFormat, parameters, Constants.SAVE_DIR);
    }
}
