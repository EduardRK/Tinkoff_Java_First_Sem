package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

public class Task4Test {
    @ParameterizedTest
    @CsvSource(value = {
        "dshgh23!@#",
        "!@#$",
        "3467t6h3r!iuvernit234",
        "dDYFSGgv3t2)(!@"
    })
    @DisplayName("Correct passwords")
    public void correctPasswords(String password) {
        Assertions.assertTrue(Task4.isValidPassword(password));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "dshgh",
        "A",
        "PWEMEFGUI yunir reys 1894gso m8"
    })
    @EmptySource
    @DisplayName("Incorrect passwords")
    public void incorrectPasswords(String password) {
        Assertions.assertFalse(Task4.isValidPassword(password));
    }
}
