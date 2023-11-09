package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task8Test {
    @Test
    @DisplayName("Example test")
    public void exampleTest() {
        Iterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1, 2, 3));
        var actual = new ArrayList<>();
        while (backwardIterator.hasNext()) {
            actual.add(backwardIterator.next());
        }
        var expected = new ArrayList<>() {{
            add(3);
            add(2);
            add(1);
        }};
        Assertions.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Integer ArrayList test")
    public void integerArrayList() {
        ArrayList<Integer> integerArrayList = new ArrayList<>() {{
            add(23);
            add(42);
            add(21);
            add(0);
            add(-10);
        }};
        Iterator<Integer> backwardIterator = new BackwardIterator<>(integerArrayList);
        var actual = new ArrayList<>();
        while (backwardIterator.hasNext()) {
            actual.add(backwardIterator.next());
        }
        var expected = new ArrayList<>() {{
            add(-10);
            add(0);
            add(21);
            add(42);
            add(23);
        }};
        Assertions.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("String map test")
    public void stringMap() {
        HashMap<String, String> stringHashMap = new HashMap<>() {{
            put("a", "1");
            put("b", "2");
            put("c", "3");
            put("d", "4");
            put("e", "5");
        }};
        Iterator<String> backwardIterator = new BackwardIterator<>(stringHashMap.keySet());
        var actual = new HashSet<>();
        while (backwardIterator.hasNext()) {
            actual.add(backwardIterator.next());
        }
        var expected = new HashSet<>() {{
            add("e");
            add("d");
            add("c");
            add("b");
            add("a");
        }};
        Assertions.assertEquals(actual, expected);
    }
}
