package edu.hw3;

import edu.hw3.task1.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class Task1Test {

    @ParameterizedTest
    @CsvSource(value = {
        "Hello world!, Svool dliow!",
        "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler, Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz, ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba"
    })
    @DisplayName("Example tests")
    public void exampleTests(String message, String expected) {
        Assertions.assertEquals(expected, Task1.atbash(message));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null and empty string")
    public void nullString(String message) {
        Assertions.assertEquals(message, Task1.atbash(message));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1234---==++",
        "1234---==++"
    })
    @DisplayName("String without letters")
    public void stringWithoutLetters(String message) {
        Assertions.assertEquals(message, Task1.atbash(message));
    }
}
