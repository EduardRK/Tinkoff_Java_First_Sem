package edu.hw2.task2;

public class Rectangle {
    protected final int width;
    protected final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
