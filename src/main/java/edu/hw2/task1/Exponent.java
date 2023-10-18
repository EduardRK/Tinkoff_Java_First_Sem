package edu.hw2.task1;

public record Exponent(double base, double power) implements Expr {

    public Exponent(double base, Expr power) {
        this(base, power.evaluate());
    }

    public Exponent(Expr base, double power) {
        this(base.evaluate(), power);
    }

    public Exponent(Expr base, Expr power) {
        this(base.evaluate(), power.evaluate());
    }

    @Override
    public double evaluate() {
        return Math.pow(base, power);
    }
}
