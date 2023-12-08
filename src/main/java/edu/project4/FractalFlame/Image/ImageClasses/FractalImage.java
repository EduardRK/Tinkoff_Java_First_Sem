package edu.project4.FractalFlame.Image.ImageClasses;

import edu.project4.FractalFlame.RecordClasses.Coordinate;

public record FractalImage(Pixel[] data, int width, int height) {
    public static FractalImage create(int width, int height) {
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

    public Pixel pixel(int x, int y) {
        if (!contains(x, y)) {
            return null;
        }
        return data[y * width + x];
    }

    public Pixel pixel(Coordinate coordinate) {
        if (!contains((int) coordinate.x(), (int) coordinate.y())) {
            return null;
        }
        return data[(int) (coordinate.y() * width + coordinate.x())];
    }
}
