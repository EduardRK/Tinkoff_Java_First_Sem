package edu.project1;

public class Word {
    private final String hiddenWord;
    private String encryptedWord;

    public Word(Dictionary dictionary) {
        this.hiddenWord = dictionary.randomWord();
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
