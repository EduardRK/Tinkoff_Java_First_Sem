package edu.project1;

import java.util.Random;

public class Dictionary {
    private String[] dictionary = new String[] {"hello", "hutao", "sunshine"};

    private Dictionary() {
    }

    public String[] getDictionary() {
        return this.dictionary;
    }

    public static String randomWord() {
        Random rand = new Random();
        Dictionary dictionary = new Dictionary();
        int randomNumber = rand.nextInt(dictionary.getDictionary().length);
        return dictionary.getDictionary()[randomNumber];
    }
}
