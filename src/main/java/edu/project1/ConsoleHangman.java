package edu.project1;

public final class ConsoleHangman {
    private ConsoleHangman() {
    }

    public static void gameStart() {
        Dictionary dictionary = new Dictionary(new String[] {"hutao"});
        if (Checker.isCorrectDictionary(dictionary) && !Checker.isDictionaryEmpty(dictionary)) {
            Player player = new Player();
            Word word = new Word(dictionary);
            Answer answer = new Answer();

            Statements.startGamePhase();

            while (true) {
                Statements.inputLetterPhase(answer);

                if (Checker.isMisspell(answer)) {
                    if (Checker.isEnd(answer)) {
                        Statements.forcedEndGamePhase();
                        break;
                    }
                    Statements.misspellLetterPhase(word);

                } else if (!Checker.isRightLetter(answer, word)) {
                    Statements.wrongAnswerPhase(player, word);
                    if (LoserChecker.isPlayerLost(player)) {
                        Statements.losingPhase();
                        break;
                    }

                } else if (Checker.isRightLetter(answer, word)) {
                    Statements.rightAnswerPhase(answer, word);
                    if (WinnerChecker.isPlayerWon(word)) {
                        Statements.winningPhase();
                        break;
                    }
                }
            }
            Statements.endGamePhase();
        } else {
            Statements.incorrectDictionaryPhase();
        }
    }
}
