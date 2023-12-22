package edu.project1;

import org.jetbrains.annotations.NotNull;

public final class WinnerChecker {
    private WinnerChecker() {
    }

    public static boolean isPlayerWon(@NotNull Word word) {
        return word.getHiddenWord().equals(word.getEncryptedWord());
    }
}
