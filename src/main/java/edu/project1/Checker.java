package edu.project1;

import org.jetbrains.annotations.NotNull;

public final class Checker {
    private static final String LOOKUP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Checker() {
    }

    public static boolean isCorrectDictionary(@NotNull Dictionary dictionary) {
        for (String word : dictionary.getDictionary()) {
            if ((word == null) || (word.length() < 2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDictionaryEmpty(@NotNull Dictionary dictionary) {
        return (dictionary.getDictionary().length == 0) || (dictionary.getDictionary() == null);
    }

    public static boolean isMisspell(@NotNull Answer answer) {
        return (answer.getAnswerArray().length != 1) || (!LOOKUP.contains(answer.getAnswerString()));
    }

    public static boolean isRightLetter(@NotNull Answer answer, @NotNull Word word) {
        char answerLetter = answer.getAnswerLetter();
        char[] hiddenWordArray = word.getHiddenWord().toCharArray();
        for (char letter : hiddenWordArray) {
            if (letter == answerLetter) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnd(@NotNull Answer answer) {
        return answer.getAnswerString().equals("End");
    }
}
