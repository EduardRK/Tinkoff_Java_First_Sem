package edu.project1;

public final class WinnerChecker {
    private WinnerChecker() {
    }

    public static boolean isPlayerWon(Word word) {
        return word.getHiddenWord().equals(word.getEncryptedWord());
    }
}
