package edu.project1;

public final class Statements implements SystemMessages {
    private Statements() {
    }

    public static void startGamePhase() {
        SystemMessages.welcomeMessage();
        SystemMessages.rulesMessage();
    }

    public static void inputLetterPhase(Answer answer) {
        SystemMessages.guessALetterMessage();
        answer.readGuessLetter();
    }

    public static void forcedEndGamePhase() {
        SystemMessages.forcedEndGame();
    }

    public static void misspellLetterPhase(Answer answer, Word word) {
        SystemMessages.misspellMessage();
        SystemMessages.theHiddenWordMessage(word);
    }

    public static void wrongAnswerPhase(Player player, Answer answer, Word word) {
        player.giveWrongAnswer();
        SystemMessages.mistakeMessage(player);
        SystemMessages.theHiddenWordMessage(word);
    }

    public static void losingPhase() {
        SystemMessages.loseMessage();
    }

    public static void rightAnswerPhase(Answer answer, Word word) {
        SystemMessages.hitMessage();
        ActionsOnWords.openGuessedLettersInEncryptedWord(word, answer);
        SystemMessages.theHiddenWordMessage(word);
    }

    public static void winningPhase() {
        SystemMessages.winMessage();
    }

    public static void endGamePhase() {
        SystemMessages.endGameMessage();
    }

    public static void incorrectDictionaryPhase() {
        SystemMessages.incorrectDictionary();
    }
}
