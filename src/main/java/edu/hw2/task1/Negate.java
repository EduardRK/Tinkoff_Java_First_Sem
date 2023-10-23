package edu.hw2.task1;

public record Negate(double number) implements Expr {

    public Negate(Expr number) {
        this(number.evaluate());
    }

    @Override
    public double evaluate() {
        return -number;
    }
}
