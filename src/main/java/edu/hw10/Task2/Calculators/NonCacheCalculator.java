package edu.hw10.Task2.Calculators;

import edu.hw10.Task2.Cache;

public interface NonCacheCalculator {
    @Cache
    long calculate(int number);
}
