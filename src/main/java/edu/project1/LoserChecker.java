package edu.project1;

import org.jetbrains.annotations.NotNull;

public final class LoserChecker {
    private static final int MAX_MISTAKES = 5;

    private LoserChecker() {
    }

    public static boolean isPlayerLost(@NotNull Player player) {
        return player.getCountOfMistakes() == MAX_MISTAKES;
    }
}
