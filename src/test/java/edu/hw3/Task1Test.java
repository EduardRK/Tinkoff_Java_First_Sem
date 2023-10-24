package edu.hw3;

import edu.hw3.task1.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    @DisplayName("Example tests")
    public void exampleTests() {
        String actual = Task1.atbash("Hello world!");
        String expected = "Svool dliow!";
        Assertions.assertEquals(expected, actual);

        actual = Task1.atbash(
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");
        expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null string")
    public void nullString() {
        String actual = Task1.atbash(null);
        Assertions.assertNull(actual);
    }

    @Test
    @DisplayName("Empty string")
    public void emptyString() {
        String actual = "";
        String expected = "";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String without letters")
    public void stringWithoutLetters() {
        String actual = "1234---==++";
        String expected = "1234---==++";
        Assertions.assertEquals(expected, actual);

        actual = "????||||]]]]112";
        expected = "????||||]]]]112";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("All alphabet")
    public void allAlphabet() {
        String actual = Task1.atbash("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        String expected = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
        Assertions.assertEquals(expected, actual);
    }
}
