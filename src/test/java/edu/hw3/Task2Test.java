package edu.hw3;

import edu.hw3.task2.InvalidArgumentException;
import edu.hw3.task2.InvalidBracketsSequence;
import edu.hw3.task2.Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class Task2Test {

    @Test
    @DisplayName("Example tests")
    public void exampleTests() throws InvalidArgumentException, InvalidBracketsSequence {
        ArrayList<String> actual = Task2.clusterize("()()()");
        ArrayList<String> expected = new ArrayList<>() {{
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
    public void emptyString() throws InvalidArgumentException, InvalidBracketsSequence {
        ArrayList<String> actual = Task2.clusterize("");
        ArrayList<String> expected = new ArrayList<>() {{
            add("");
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null string")
    public void nullString() throws InvalidArgumentException, InvalidBracketsSequence {
        ArrayList<String> actual = Task2.clusterize(null);
        ArrayList<String> expected = new ArrayList<>() {{
            add(null);
        }};
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid string")
    public void invalidString() throws InvalidArgumentException, InvalidBracketsSequence {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            ArrayList<String> actual = Task2.clusterize("((12))");
        });
    }

    @Test
    @DisplayName("Invalid bracket sequence")
    public void InvalidBracketsSequence() {
        Assertions.assertThrows(InvalidBracketsSequence.class, () -> {
            ArrayList<String> actual = Task2.clusterize("(()()))()");
        });
    }
}
