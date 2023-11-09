package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("Correct substring")
    public void correctSubstring() {
        String substring = "abc";
        String string = "achfdbaabgabcaabg";
        Assertions.assertTrue(Task6.isStringContainsSubstring(string, substring));

        substring = "chf";
        string = "achfdbaabgabcaabg";
        Assertions.assertTrue(Task6.isStringContainsSubstring(string, substring));

        substring = "123";
        string = "567492810912390934";
        Assertions.assertTrue(Task6.isStringContainsSubstring(string, substring));

        substring = "%^|*(!@";
        string = "(!&#&*!*^!^^#(!@()*%^|*(!@";
        Assertions.assertTrue(Task6.isStringContainsSubstring(string, substring));

        substring = "";
        string = "(!&#&*!*^!^^#(!@()*%^*(!@";
        Assertions.assertTrue(Task6.isStringContainsSubstring(string, substring));

        substring = "";
        string = "";
        Assertions.assertTrue(Task6.isStringContainsSubstring(string, substring));
    }

    @Test
    @DisplayName("Incorrect substring")
    public void incorrectSubstring() {
        String substring = "p";
        String string = "achfdbaabgabcaabg";
        Assertions.assertFalse(Task6.isStringContainsSubstring(string, substring));

        substring = "12";
        string = "achfdbaabgabcaabg";
        Assertions.assertFalse(Task6.isStringContainsSubstring(string, substring));

        substring = "0000";
        string = "567492810912390934";
        Assertions.assertFalse(Task6.isStringContainsSubstring(string, substring));

        substring = "qwe";
        string = "";
        Assertions.assertFalse(Task6.isStringContainsSubstring(string, substring));

        substring = "@#!!##!";
        string = "*(^)&^&*(%^&!@%%^%#$%^(";
        Assertions.assertFalse(Task6.isStringContainsSubstring(string, substring));

        substring = "--";
        string = "!()!+#!(#+*12!X@T*X#";
        Assertions.assertFalse(Task6.isStringContainsSubstring(string, substring));
    }
}
