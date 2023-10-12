package edu.project1;

public class Word {
    private final String hiddenWord;
    private String encryptedWord;

    public Word(String hiddenWord) {
        this.hiddenWord = hiddenWord;
        this.encryptedWord = "*".repeat(hiddenWord.length());
    }

    public String getEncryptedWord() {
        return encryptedWord;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setEncryptedWord(String encryptedWord) {
        this.encryptedWord = encryptedWord;
    }
}
