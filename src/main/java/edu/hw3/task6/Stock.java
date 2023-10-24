package edu.hw3.task6;

public record Stock(int price) implements Comparable<Stock> {
    @Override
    public int compareTo(Stock other) {
        return other.price - this.price;
    }
}
