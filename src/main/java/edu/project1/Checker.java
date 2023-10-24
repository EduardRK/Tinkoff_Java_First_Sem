package edu.project1;

public final class Checker {
    private Checker() {
    }

    private static final String LOOKUP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isCorrectDictionary(Dictionary dictionary) {
        for (String word : dictionary.getDictionary()) {
            if ((word == null) || (word.length() < 2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDictionaryEmpty(Dictionary dictionary) {
        return (dictionary.getDictionary().length == 0) || (dictionary.getDictionary() == null);
    }

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
