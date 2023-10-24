package edu.hw3.task6;

import java.util.PriorityQueue;

public class StockMarket implements IStockMarket {
    private final PriorityQueue<Stock> stockMarket = new PriorityQueue<>();

    public StockMarket(Stock... stocks) {
        for (Stock stock : stocks) {
            add(stock);
        }
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
