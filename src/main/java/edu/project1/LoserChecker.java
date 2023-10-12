package edu.project1;

public final class LoserChecker {
    private LoserChecker() {
    }

    private static final int MAX_MISTAKES = 5;

    public static boolean isMistakesMoreThanFive(Player player) {
        return player.getCountOfMistakes() == MAX_MISTAKES;
    }
}
