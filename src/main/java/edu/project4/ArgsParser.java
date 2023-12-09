package edu.project4;

import edu.project4.FractalFlame.Image.ImageClasses.ImageFormat;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record ArgsParser(Path path, List<String> variationsType, ImageFormat imageFormat, List<Double> parameters) {
    private static final Set<String> IMAGE_FORMATS =
        new HashSet<>(Set.of(ImageFormat.PNG.name(), ImageFormat.BMP.name(), ImageFormat.JPEG.name()));
    private static final ImageFormat DEFAULT_IMAGE_FORMAT = ImageFormat.PNG;
    private static final List<String> DEFAULT_TYPES = new ArrayList<>(List.of("curl", "exponential"));
    private static final List<Double> DEFAULT_PARAMETERS = new ArrayList<>();

    public static ArgsParser create(String[] args) {
        List<String> variations = new ArrayList<>();
        List<Double> parameters = new ArrayList<>();
        ImageFormat imageFormat1 = null;

        if (args.length > 0) {
            Path saveDir = Path.of(args[0]);
            int i = 1;
            while (i < args.length && !IMAGE_FORMATS.contains(args[i])) {
                variations.add(args[i]);
                ++i;
            }
            if (i < args.length) {
                imageFormat1 = setImageFormat(args[i]);
                ++i;
            }
            while (i < args.length) {
                parameters.add(Double.parseDouble(args[i]));
                ++i;
            }

            return new ArgsParser(
                saveDir,
                variations.isEmpty() ? DEFAULT_TYPES : variations,
                imageFormat1 == null ? DEFAULT_IMAGE_FORMAT : imageFormat1,
                parameters
            );
        }
        throw new IllegalArgumentException("The path must be specified");
    }

    private static ImageFormat setImageFormat(String imageFormat) {
        return switch (imageFormat) {
            case "PNG" -> ImageFormat.PNG;
            case "JPEG" -> ImageFormat.JPEG;
            case "BMP" -> ImageFormat.BMP;
            default -> null;
        };
    }
}
