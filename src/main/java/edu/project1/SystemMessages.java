package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface SystemMessages {

    Logger LOGGER = LogManager.getLogger();

    static void welcomeMessage() {
        LOGGER.info("Welcome!");
    }

    static void rulesMessage() {
        LOGGER.info("In this game you need to guess the hidden word by making less than 5 mistakes.");
        LOGGER.info("You can only guess one letter per turn.");
        LOGGER.info("All words have only lowercase letters.");
        LOGGER.info("If you want to finish the game earlier, enter the word \"End\"");
    }

    static void guessALetterMessage() {
        LOGGER.info("Guess the letter:");
    }

    static void mistakeMessage(Player player) {
        LOGGER.info("Missed, mistake " + player.getCountOfMistakes() + " out of 5.");
    }

    static void misspellMessage() {
        LOGGER.info("You have committed a misspell, try again.");
    }

    static void theHiddenWordMessage(Word word) {
        LOGGER.info("The word: " + word.getEncryptedWord());
    }

    static void hitMessage() {
        LOGGER.info("Hit!");
    }

    static void loseMessage() {
        LOGGER.info("You lost!");
    }

    static void winMessage() {
        LOGGER.info("You win!");
    }

    static void endGameMessage() {
        LOGGER.info("Thank you for playing my game.");
    }

    static void forcedEndGame() {
        LOGGER.info("You have forcibly completed the game.");
    }

    static void incorrectDictionary() {
        LOGGER.info("the dictionary has incorrect words.");
    }
}
