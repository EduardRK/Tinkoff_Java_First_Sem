package edu.hw2.task1;

public record Constant(double number) implements Expr {
    public Constant(Expr number) {
        this(number.evaluate());
    }

    @Override
    public double evaluate() {
        return number;
    }
}


