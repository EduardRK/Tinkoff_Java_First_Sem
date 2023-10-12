package edu.project1;

public final class ConsoleHangman {
    private ConsoleHangman() {
    }

    public static void gameStart() {
        Player player = new Player(0);
        Word word = new Word(Dictionary.randomWord());
        Answer answer = new Answer();

        SystemMessages.welcomeMessage();
        SystemMessages.rulesMessage();

        while (true) {
            Statement.inputLetterPhase(answer);

            if (Checker.isMisspell(answer)) {
                if (Checker.isEnd(answer)) {
                    SystemMessages.forcedEndGame();
                    break;
                }
                Statement.misspellLetterPhase(answer, word);

            } else if (!Checker.isRightLetter(answer, word)) {
                Statement.wrongAnswerPhase(player, answer, word);
                if (LoserChecker.isMistakesMoreThanFive(player)) {
                    SystemMessages.loseMessage();
                    break;
                }

            } else if (Checker.isRightLetter(answer, word)) {
                Statement.rightAnswerPhase(answer, word);
                if (WinnerChecker.isWordWasGuessed(word)) {
                    SystemMessages.winMessage();
                    break;
                }
            }
        }
        SystemMessages.endGameMessage();
    }
}
