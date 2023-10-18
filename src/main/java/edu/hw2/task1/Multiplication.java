package edu.hw2.task1;

public record Multiplication(double left, double right) implements Expr {

    public Multiplication(double left, Expr right) {
        this(left, right.evaluate());
    }

    public Multiplication(Expr left, double right) {
        this(left.evaluate(), right);
    }

    public Multiplication(Expr left, Expr right) {
        this(left.evaluate(), right.evaluate());
    }

    @Override
    public double evaluate() {
        return left * right;
    }
}
