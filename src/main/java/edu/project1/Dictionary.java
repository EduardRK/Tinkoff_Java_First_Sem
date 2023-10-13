package edu.project1;

import java.util.Random;

public class Dictionary {
    private final String[] dictionary;

    public Dictionary(String[] words) {
        dictionary = words;
    }

    public String[] getDictionary() {
        return this.dictionary;
    }

    public String randomWord() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(dictionary.length);
        return dictionary[randomNumber];
    }
}
