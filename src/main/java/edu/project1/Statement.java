package edu.project1;

public final class Statement {
    private Statement() {
    }

    public static void inputLetterPhase(Answer answer) {
        SystemMessages.guessALetterMessage();
        answer.readGuessLetter();
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

    public static void rightAnswerPhase(Answer answer, Word word) {
        SystemMessages.hitMessage();
        ActionsOnWords.openGuessedLettersInEncryptedWord(word, answer);
        SystemMessages.theHiddenWordMessage(word);
    }
}
