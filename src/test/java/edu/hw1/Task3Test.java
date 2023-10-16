package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {

    @Test
    @DisplayName("Not null array")
    void notNullArray() {
        int[] firstArray = {2, 3, 4};
        int[] secondArray = {1, 2, 3, 5};
        Assertions.assertTrue(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {1};
        secondArray = new int[] {9};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {2, 3};
        secondArray = new int[] {2, 3};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {1, 3, 90, 100};
        secondArray = new int[] {40, 49, 100, 101};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {1, 2, 9, 12};
        secondArray = new int[] {-100, 100};
        Assertions.assertTrue(Task3.isNestable(firstArray, secondArray));
    }

    @Test
    @DisplayName("Null array")
    void nullArray() {
        int[] firstArray = {};
        int[] secondArray = {1, 2, 3, 5};
        Assertions.assertTrue(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {1};
        secondArray = new int[] {};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {};
        secondArray = new int[] {};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));
    }
}
