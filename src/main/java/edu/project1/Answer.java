package edu.project1;

import java.util.Scanner;

public class Answer {
    private char[] answer;
    private static final Scanner IN = new Scanner(System.in);

    public char[] getAnswerArray() {
        return answer;
    }

    public char getAnswerLetter() {
        return answer[0];
    }

    public void setAnswer(String answer) {
        this.answer = answer.toCharArray();
    }

    public String getAnswerString() {
        return new String(answer);
    }

    public void readGuessLetter() {
        answer = IN.next().toCharArray();
    }
}
