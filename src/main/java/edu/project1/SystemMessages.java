package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SystemMessages {
    private SystemMessages() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void welcomeMessage() {
        LOGGER.info("Welcome!");
    }

    public static void rulesMessage() {
        LOGGER.info("In this game you need to guess the hidden word by making less than 5 mistakes.");
        LOGGER.info("You can only guess one letter per turn.");
        LOGGER.info("All words have only lowercase letters.");
        LOGGER.info("If you want to finish the game earlier, enter the word \"End\"");
    }

    public static void guessALetterMessage() {
        LOGGER.info("Guess the letter:");
    }

    public static void mistakeMessage(Player player) {
        LOGGER.info("Missed, mistake " + player.getCountOfMistakes() + " out of 5.");
    }

    public static void misspellMessage() {
        LOGGER.info("You have committed a misspell, try again.");
    }

    public static void theHiddenWordMessage(Word word) {
        LOGGER.info("The word: " + word.getEncryptedWord());
    }

    public static void hitMessage() {
        LOGGER.info("Hit!");
    }

    public static void loseMessage() {
        LOGGER.info("You lost!");
    }

    public static void winMessage() {
        LOGGER.info("You win!");
    }

    public static void endGameMessage() {
        LOGGER.info("Thank you for playing my game.");
    }

    public static void forcedEndGame() {
        LOGGER.info("You have forcibly completed the game.");
    }
}
