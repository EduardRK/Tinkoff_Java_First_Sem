package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    @DisplayName("Empty tests")
    public void emptyTests() {
        String string = "";
        String subsequence = "";
        Assertions.assertTrue(Task6.isStringContainsSubsequence(string, subsequence));

        string = "sfqxeq";
        subsequence = "";
        Assertions.assertTrue(Task6.isStringContainsSubsequence(string, subsequence));

        string = "";
        subsequence = "kscg";
        Assertions.assertFalse(Task6.isStringContainsSubsequence(string, subsequence));
    }
}
