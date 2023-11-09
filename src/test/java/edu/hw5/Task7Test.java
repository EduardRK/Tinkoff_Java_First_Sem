package edu.hw5;

import org.junit.jupiter.api.Test;

public class Task7Test {
    @Test
    public void test() {
        String string = "";
        boolean flag = Task7.isContainsAtLeastThreeCharactersAndThirdZero(string);
        System.out.println(flag);
    }

    @Test
    public void test2() {
        String string = "";
        boolean flag = Task7.isContainsAtLeastOneAndNoMoreThreeCharacters(string);
        System.out.println(flag);
    }

    @Test
    public void test3() {
        String string = "1";
        boolean flag = Task7.isStartsAndEndsWithSameCharacter(string);
        System.out.println(flag);
    }
}
