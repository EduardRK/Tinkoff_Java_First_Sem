package edu.hw3.task6;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockMarket implements IStockMarket {
    private final Queue<Stock> stockMarket = new PriorityQueue<>();

    public StockMarket(Stock... stocks) {
        stockMarket.addAll(Arrays.asList(stocks));
    }

    public StockMarket(List<Stock> stocks) {
        stockMarket.addAll(stocks);
    }

    @Override
    public void add(Stock stock) {
        stockMarket.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockMarket.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockMarket.peek();
    }
}
