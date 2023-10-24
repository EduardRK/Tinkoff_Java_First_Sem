package edu.project1;

public class Player {
    private int countOfMistakes;

    Player() {
        this.countOfMistakes = 0;
    }

    public int getCountOfMistakes() {
        return countOfMistakes;
    }

    public void giveWrongAnswer() {
        countOfMistakes++;
    }
}
