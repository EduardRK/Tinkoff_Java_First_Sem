package edu.project4.FractalFlame.Image.ImageClasses;

import edu.project4.FractalFlame.RecordClasses.Coordinate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record FractalImage(Pixel[] data, int width, int height) {
    @Contract("_, _ -> new")
    public static @NotNull FractalImage create(int width, int height) {
        Pixel[] pixels = new Pixel[width * height];
        for (int i = 0; i < width * height; ++i) {
            pixels[i] = new Pixel();
        }
        return new FractalImage(pixels, width, height);
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < width
            && y >= 0 && y < height;
    }

    @Contract(pure = true)
    public @Nullable Pixel pixel(int x, int y) {
        if (!contains(x, y)) {
            return null;
        }
        return data[y * width + x];
    }

    public @Nullable Pixel pixel(@NotNull Coordinate coordinate) {
        if (!contains((int) coordinate.x(), (int) coordinate.y())) {
            return null;
        }
        return data[(int) (coordinate.y() * width + coordinate.x())];
    }
}
