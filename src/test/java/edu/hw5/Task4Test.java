package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    @DisplayName("Correct passwords")
    public void correctPasswords() {
        String password = "dshgh23!@#";
        Assertions.assertTrue(Task4.isValidPassword(password));

        password = "!@#$";
        Assertions.assertTrue(Task4.isValidPassword(password));

        password = "3467t6h3r!iuvernit234";
        Assertions.assertTrue(Task4.isValidPassword(password));

        password = "dDYFSGgv3t2)(!@";
        Assertions.assertTrue(Task4.isValidPassword(password));
    }

    @Test
    @DisplayName("Incorrect passwords")
    public void incorrectPasswords() {
        String password = "dshgh";
        Assertions.assertFalse(Task4.isValidPassword(password));

        password = "A";
        Assertions.assertFalse(Task4.isValidPassword(password));

        password = "";
        Assertions.assertFalse(Task4.isValidPassword(password));

        password = "PWEMEFGUI yunir reys 1894gso m8";
        Assertions.assertFalse(Task4.isValidPassword(password));
    }
}
