package edu.project1;

public final class WinnerChecker {
    private WinnerChecker() {
    }

    public static boolean isWordWasGuessed(Word word) {
        return word.getHiddenWord().equals(word.getEncryptedWord());
    }
}
