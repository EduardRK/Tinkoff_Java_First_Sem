package edu.project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Project1Test {

    @Test
    @DisplayName("Misspells test more letters")
    public void misspellAnswerMoreLetters() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hutao"});
        Word word = new Word(dictionary);

        int expectedPlayerMistakes = player.getCountOfMistakes();
        String expectedEncryptedWord = word.getEncryptedWord();

        answer.setAnswer("qwe");
        Statements.misspellLetterPhase(answer, word);

        Assertions.assertTrue(Checker.isMisspell(answer));
        Assertions.assertEquals(expectedPlayerMistakes, player.getCountOfMistakes());
        Assertions.assertEquals(expectedEncryptedWord, word.getEncryptedWord());
    }

    @Test
    @DisplayName("Misspells test null answer")
    public void misspellAnswerNullAnswer() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hutao"});
        Word word = new Word(dictionary);

        int expectedPlayerMistakes = player.getCountOfMistakes();
        String expectedEncryptedWord = word.getEncryptedWord();

        answer.setAnswer("");
        Statements.misspellLetterPhase(answer, word);

        Assertions.assertTrue(Checker.isMisspell(answer));
        Assertions.assertEquals(expectedPlayerMistakes, player.getCountOfMistakes());
        Assertions.assertEquals(expectedEncryptedWord, word.getEncryptedWord());
    }

    @Test
    @DisplayName("Misspells test digits")
    public void misspellAnswerDigits() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hutao"});
        Word word = new Word(dictionary);

        int expectedPlayerMistakes = player.getCountOfMistakes();
        String expectedEncryptedWord = word.getEncryptedWord();

        answer.setAnswer("2");
        Statements.misspellLetterPhase(answer, word);

        Assertions.assertTrue(Checker.isMisspell(answer));
        Assertions.assertEquals(expectedPlayerMistakes, player.getCountOfMistakes());
        Assertions.assertEquals(expectedEncryptedWord, word.getEncryptedWord());
    }

    @Test
    @DisplayName("Forced end game")
    public void forcedEndGame() {
        Answer answer = new Answer();

        answer.setAnswer("End");
        Assertions.assertTrue(Checker.isEnd(answer));
    }

    @Test
    @DisplayName("Correct answer one correct letter")
    public void correctAnswerOneCorrectLetter() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hutao"});
        Word word = new Word(dictionary);

        int expectedPlayerMistakes = player.getCountOfMistakes();
        String expectedEncryptedWord = "h****";

        answer.setAnswer("h");
        Statements.rightAnswerPhase(answer, word);

        Assertions.assertTrue(Checker.isRightLetter(answer, word));
        Assertions.assertEquals(expectedPlayerMistakes, player.getCountOfMistakes());
        Assertions.assertEquals(expectedEncryptedWord, word.getEncryptedWord());
    }

    @Test
    @DisplayName("Correct answer two and more correct letters")
    public void correctAnswerTwoAndMoreCorrectLetters() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hello"});
        Word word = new Word(dictionary);

        int expectedPlayerMistakes = player.getCountOfMistakes();
        String expectedEncryptedWord = "**ll*";

        answer.setAnswer("l");
        Statements.rightAnswerPhase(answer, word);

        Assertions.assertTrue(Checker.isRightLetter(answer, word));
        Assertions.assertEquals(expectedPlayerMistakes, player.getCountOfMistakes());
        Assertions.assertEquals(expectedEncryptedWord, word.getEncryptedWord());
    }

    @Test
    @DisplayName("Correct answer and won")
    public void correctAnswerAndWon() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hello"});
        Word word = new Word(dictionary);

        int expectedPlayerMistakes = player.getCountOfMistakes();
        String expectedEncryptedWord = "hello";

        answer.setAnswer("h");
        Statements.rightAnswerPhase(answer, word);
        answer.setAnswer("e");
        Statements.rightAnswerPhase(answer, word);
        answer.setAnswer("l");
        Statements.rightAnswerPhase(answer, word);
        answer.setAnswer("o");
        Statements.rightAnswerPhase(answer, word);

        Assertions.assertTrue(WinnerChecker.isPlayerWon(word));
        Assertions.assertEquals(expectedPlayerMistakes, player.getCountOfMistakes());
        Assertions.assertEquals(expectedEncryptedWord, word.getEncryptedWord());
    }

    @Test
    @DisplayName("Wrong answer")
    public void wrongAnswer() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hutao"});
        Word word = new Word(dictionary);

        int expectedPlayerMistakes = player.getCountOfMistakes() + 1;
        String expectedEncryptedWord = "*****";

        answer.setAnswer("l");
        Statements.wrongAnswerPhase(player, answer, word);

        Assertions.assertFalse(Checker.isRightLetter(answer, word));
        Assertions.assertEquals(expectedPlayerMistakes, player.getCountOfMistakes());
        Assertions.assertEquals(expectedEncryptedWord, word.getEncryptedWord());
    }

    @Test
    @DisplayName("Wrong answer and lost")
    public void wrongAnswerAndLost() {
        Answer answer = new Answer();
        Player player = new Player();
        Dictionary dictionary = new Dictionary(new String[] {"hutao"});
        Word word = new Word(dictionary);

        for (int i = 0; i < 4; ++i) {
            player.giveWrongAnswer();
        }

        answer.setAnswer("l");
        Statements.wrongAnswerPhase(player, answer, word);

        Assertions.assertTrue(LoserChecker.isPlayerLost(player));
    }

    @Test
    @DisplayName("The dictionary has an incorrect word")
    public void incorrectWordInDictionary() {
        Dictionary dictionary = new Dictionary(new String[] {"hutao", "f"});
        Assertions.assertFalse(Checker.isCorrectDictionary(dictionary));

        dictionary = new Dictionary((new String[] {"hutao", "", "dfg"}));
        Assertions.assertFalse(Checker.isCorrectDictionary(dictionary));
    }

    @Test
    @DisplayName("The dictionary is empty.")
    public void dictionaryIsEmpty() {
        Dictionary dictionary = new Dictionary(new String[] {});
        Assertions.assertTrue(Checker.isDictionaryEmpty(dictionary));
    }
}
