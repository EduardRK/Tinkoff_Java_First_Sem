package edu.hw3;

import edu.hw3.task2.InvalidBracketsSequence;
import edu.hw3.task2.Task2;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    @DisplayName("Example tests")
    public void exampleTests() throws InvalidBracketsSequence {
        List<String> actual = Task2.clusterize("()()()");
        List<String> expected = new ArrayList<>() {{
            add("()");
            add("()");
            add("()");
        }};
        Assertions.assertEquals(expected, actual);

        actual = Task2.clusterize("((()))");
        expected = new ArrayList<>() {{
            add("((()))");
        }};
        Assertions.assertEquals(expected, actual);

        actual = Task2.clusterize("((()))(())()()(()())");
        expected = new ArrayList<>() {{
            add("((()))");
            add("(())");
            add("()");
            add("()");
            add("(()())");
        }};
        Assertions.assertEquals(expected, actual);

        actual = Task2.clusterize("((())())(()(()()))");
        expected = new ArrayList<>() {{
            add("((())())");
            add("(()(()()))");
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty string")
    public void emptyString() throws InvalidBracketsSequence {
        List<String> actual = Task2.clusterize("");
        List<String> expected = new ArrayList<>() {{
            add("");
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null string")
    public void nullString() throws InvalidBracketsSequence {
        List<String> actual = Task2.clusterize(null);
        List<String> expected = new ArrayList<>() {{
            add(null);
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid string")
    public void invalidString() throws InvalidBracketsSequence {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<String> actual = Task2.clusterize("((12))");
        });
    }

    @Test
    @DisplayName("Invalid bracket sequence")
    public void InvalidBracketsSequence() {
        Assertions.assertThrows(InvalidBracketsSequence.class, () -> {
            List<String> actual = Task2.clusterize("(()()))()");
        });
    }
}
