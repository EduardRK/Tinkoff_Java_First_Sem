package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {

    @Test
    @DisplayName("Nestable")
    public void nestable() {
        int[] firstArray = {2, 3, 4};
        int[] secondArray = {1, 2, 3, 5};
        Assertions.assertTrue(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {1, 2, 9, 12};
        secondArray = new int[] {-100, 100};
        Assertions.assertTrue(Task3.isNestable(firstArray, secondArray));
    }

    @Test
    @DisplayName("Not nestable")
    public void notNestable() {
        int[] firstArray = new int[] {1};
        int[] secondArray = new int[] {9};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {2, 3};
        secondArray = new int[] {2, 3};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));

        firstArray = new int[] {1, 3, 90, 100};
        secondArray = new int[] {40, 49, 100, 101};
        Assertions.assertFalse(Task3.isNestable(firstArray, secondArray));
    }

    @Test
    @DisplayName("Empty arrays")
    public void emptyArrays() {
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

    @Test
    @DisplayName("Null arrays")
    public void nullArrays() {
        int[] array = {1, 2, 3, 5};
        Assertions.assertFalse(Task3.isNestable(null, array));

        Assertions.assertFalse(Task3.isNestable(array, null));

        Assertions.assertFalse(Task3.isNestable(null, null));
    }
}
