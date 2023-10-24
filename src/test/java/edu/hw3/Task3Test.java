package edu.hw3;

import edu.hw3.task3.Task3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class Task3Test {

    @Test
    @DisplayName("Example tests")
    public void exampleTests() {
        HashMap<Object, Integer> actual = Task3.freqDict(new String[] {"a", "bb", "a", "bb"});
        HashMap<Object, Integer> expected = new HashMap<>() {{
            put("bb", 2);
            put("a", 2);
        }};
        Assertions.assertEquals(expected, actual);

        actual = Task3.freqDict(new String[] {"this", "and", "that", "and"});
        expected = new HashMap<>() {{
            put("that", 1);
            put("and", 2);
            put("this", 1);
        }};
        Assertions.assertEquals(expected, actual);

        actual = Task3.freqDict(new String[] {"код", "код", "код", "bug"});
        expected = new HashMap<>() {{
            put("код", 3);
            put("bug", 1);
        }};
        Assertions.assertEquals(expected, actual);

        actual = Task3.freqDict(new Integer[] {1, 1, 2, 2});
        expected = new HashMap<>() {{
            put(1, 2);
            put(2, 2);
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Other cases")
    public void otherCases() {
        HashMap<Object, Integer> actual = Task3.freqDict(new Double[] {1.3, 2.3, 3.3, 4.3, 1.3, 10D});
        HashMap<Object, Integer> expected = new HashMap<>() {{
            put(1.3, 2);
            put(2.3, 1);
            put(3.3, 1);
            put(4.3, 1);
            put(10D, 1);
        }};
        Assertions.assertEquals(expected, actual);

        actual = Task3.freqDict(new Float[] {1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F});
        expected = new HashMap<>() {{
            put(1F, 12);
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty array")
    public void emptyArray() {
        HashMap<Object, Integer> actual = Task3.freqDict(new Character[] {});
        HashMap<Object, Integer> expected = new HashMap<>();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null array")
    public void nullArray() {
        HashMap<Object, Integer> actual = Task3.freqDict(null);
        Assertions.assertNull(actual);
    }
}
