package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Word {
    private final String hiddenWord;
    private String encryptedWord;

    public Word(@NotNull Dictionary dictionary) {
        this.hiddenWord = dictionary.randomWord();
        this.encryptedWord = "*".repeat(hiddenWord.length());
    }

    public String getEncryptedWord() {
        return encryptedWord;
    }

    public void setEncryptedWord(String encryptedWord) {
        this.encryptedWord = encryptedWord;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }
}
