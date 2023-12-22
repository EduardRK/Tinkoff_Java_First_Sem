package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class Task6Test {
    @ParameterizedTest
    @CsvSource(value = {
        "achfdbaabgabcaabg, abc",
        "achfdbaabgabcaabg, chf",
        "567492810912390934, 123",
        "(!&#&*!*^!^^#(!@()*%^|*(!@, %^|*(!@, %^|*(!@",
        "ahbgdc, abc"
    })
    @DisplayName("Correct subsequence")
    public void correctSubsequence(String string, String subsequence) {
        Assertions.assertTrue(Task6.isStringContainsSubsequence(string, subsequence));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "achfdbaabgabcaabg, plkm",
        "achfdbaabgabcaabg, 12",
        "567492810912390934, 0000",
        "*(^)&^&*(%^&!@%%^%#$%^(, @#!!##!",
        "!()!+#!(#+*12!X@T*X#, --",
        " , ",
        " , hsdjfgms",
        "dslf, ",
        "ahbgdc, axc"

    })
    @DisplayName("Incorrect subsequence")
    public void incorrectSubsequence(String string, String subsequence) {
        Assertions.assertFalse(Task6.isStringContainsSubsequence(string, subsequence));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Empty tests")
    public void emptyTests(String string) {
        Assertions.assertTrue(Task6.isStringContainsSubsequence(string, string));
        Assertions.assertTrue(Task6.isStringContainsSubsequence("sfqxeq", string));
        Assertions.assertFalse(Task6.isStringContainsSubsequence(string, "kscg"));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null test")
    public void nullTest(String string) {
        Assertions.assertFalse(Task6.isStringContainsSubsequence(string, string));
        Assertions.assertFalse(Task6.isStringContainsSubsequence("qwerty", string));
        Assertions.assertFalse(Task6.isStringContainsSubsequence(string, "qwerty"));
    }
}
