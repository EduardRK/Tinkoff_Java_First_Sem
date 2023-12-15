package edu.hw10.Task2.Calculators;

import edu.hw10.Task2.Cache;

public interface CacheCalculator {
    @Cache(persist = true)
    long calculate(int number);
}
