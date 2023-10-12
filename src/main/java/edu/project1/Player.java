package edu.project1;

public class Player {
    private int countOfMistakes;

    Player(int countOfMistakes) {
        this.countOfMistakes = countOfMistakes;
    }

    public int getCountOfMistakes() {
        return countOfMistakes;
    }

    public void giveWrongAnswer() {
        countOfMistakes++;
    }
}
