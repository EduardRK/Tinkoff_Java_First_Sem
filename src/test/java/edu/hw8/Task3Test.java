package edu.hw8;

import edu.hw8.Task3.PasswordHacker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @NotNull
    private static PasswordHacker getPasswordHacker() {
        List<String> data = new ArrayList<>(List.of(
            "a.v.petrov  76d80224611fc919a5d54f0ff9fba446",
            "v.v.belov   33e12fa488ff45dbdf7c0cf6eb26be9a",
            "a.s.ivanov  fdc9e0acccd5b966213f7acc2d46264e",
            "k.p.maslov  40e45048337ccd321f4796e508b17b8b",
            "d.on.simon   600c6976187ec0c4c1734439cfeba5db",
            "i.am.grut   19e09d526af9bf98eabdd4a76ed180d1",
            "b.b.qqq   35971b115f721d593ffc483f57b95bef",
            "mr.robert   4ddf7fd96ffcf749d2f1ee6efb64cc88"
        ));

        return new PasswordHacker(data);
    }

    @Test
    @DisplayName("Test password hacker")
    public void passwordHacker() {
        Map<String, String> expected = new HashMap<>(Map.of(
            "a.v.petrov", "qwe",
            "v.v.belov", "1lp",
            "a.s.ivanov", "9mz",
            "k.p.maslov", "Azq0",
            "mr.robert", "ZZZZ",
            "d.on.simon", "dAsz",
            "b.b.qqq", "8zQ0",
            "i.am.grut", "QWER"
        ));

        PasswordHacker passwordHacker = getPasswordHacker();
        passwordHacker.hackingPasswords();
        Map<String, String> actual = passwordHacker.getDecryptedPasswords();
        Assertions.assertEquals(expected.entrySet().size(), actual.entrySet().size());
        for (String key : expected.keySet()) {
            Assertions.assertEquals(expected.get(key), actual.get(key));
        }
    }
}
