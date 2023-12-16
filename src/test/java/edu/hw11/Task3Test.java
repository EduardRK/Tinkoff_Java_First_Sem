package edu.hw11;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    public void test() {
        String string = "q w e r 123    qwe qwe qwe qwe";
        String[] strings = string.split(" ");

        System.out.println(strings.length);
        System.out.println(Arrays.toString(strings));
    }
}
