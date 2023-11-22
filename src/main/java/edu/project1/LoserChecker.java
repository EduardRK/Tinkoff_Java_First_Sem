package edu.project1;

public final class LoserChecker {
    private static final int MAX_MISTAKES = 5;

    private LoserChecker() {
    }

    public static boolean isPlayerLost(Player player) {
        return player.getCountOfMistakes() == MAX_MISTAKES;
    }
}
