package edu.project1;

public final class Checker {
    private Checker() {
    }

    private static final String LOOKUP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isMisspell(Answer answer) {
        return (answer.getAnswerArray().length != 1) || (!LOOKUP.contains(answer.getAnswerString()));
    }

    public static boolean isRightLetter(Answer answer, Word word) {
        char answerLetter = answer.getAnswerLetter();
        char[] hiddenWordArray = word.getHiddenWord().toCharArray();
        for (char letter : hiddenWordArray) {
            if (letter == answerLetter) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnd(Answer answer) {
        return answer.getAnswerString().equals("End");
    }
}
