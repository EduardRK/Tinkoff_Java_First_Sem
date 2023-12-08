package edu.project4.FractalFlame.Image;

import edu.project4.FractalFlame.Image.ImageClasses.FractalImage;
import edu.project4.FractalFlame.Image.ImageClasses.ImageFormat;
import edu.project4.FractalFlame.Image.ImageClasses.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.imageio.ImageIO;

public final class ImageSaver {
    private ImageSaver() {

    }

    public static void save(FractalImage fractalImage, ImageFormat imageFormat, Path path) {
        BufferedImage bufferedImage =
            new BufferedImage(fractalImage.width(), fractalImage.height(), BufferedImage.TYPE_INT_RGB);
        Path savePath = getSavePath(imageFormat, path);
        for (int x = 0; x < fractalImage.width(); ++x) {
            for (int y = 0; y < fractalImage.height(); ++y) {
                Pixel pixel = fractalImage.pixel(x, y);
                Color color = new Color(pixel.red(), pixel.green(), pixel.blue());
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        try {
            ImageIO.write(bufferedImage, imageFormat.name().toLowerCase(Locale.ROOT), savePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Path getSavePath(ImageFormat imageFormat, Path path) {
        File[] files = path.toFile().listFiles();
        String imageType = imageFormat.name().toLowerCase();
        String imagePath = path + "/image";
        if (files != null) {
            Set<File> fileSet = new HashSet<>(Set.of(files));
            int i = 1;
            Path newPath = Path.of(imagePath + i + "." + imageType);
            while (true) {
                if (!fileSet.contains(newPath.toFile())) {
                    return newPath;
                }
                ++i;
                newPath = Path.of(imagePath + i + "." + imageType);
            }
        }
        return Path.of(imagePath + "." + imageType);
    }
}
