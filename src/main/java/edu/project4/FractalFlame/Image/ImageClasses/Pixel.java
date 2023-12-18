package edu.project4.FractalFlame.Image.ImageClasses;

import edu.project4.FractalFlame.Transformations.Variations.AffineTransformation;

public class Pixel {
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private long count = 0;
    private double normal;

    public Pixel() {

    }

    public int red() {
        return red;
    }

    public int blue() {
        return blue;
    }

    public int green() {
        return green;
    }

    public long count() {
        return count;
    }

    public double normal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public void setRed(double red) {
        this.red = (int) red;
    }

    public void setGreen(double green) {
        this.green = (int) green;
    }

    public void setBlue(double blue) {
        this.blue = (int) blue;
    }

    public void setColor(AffineTransformation affineTransformation) {
        if (count == 0) {
            red = affineTransformation.color().getRed();
            green = affineTransformation.color().getGreen();
            blue = affineTransformation.color().getBlue();
        } else {
            red = (red + affineTransformation.color().getRed()) / 2;
            green = (green + affineTransformation.color().getGreen()) / 2;
            blue = (blue + affineTransformation.color().getBlue()) / 2;
        }
    }

    public void hit() {
        count++;
    }
}
