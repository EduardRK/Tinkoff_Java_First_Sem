package edu.project1;

public final class ActionsOnWords {
    private ActionsOnWords() {
    }

    private static int[] appendElementInArray(int[] array, int element) {
        int[] updateArray = new int[array.length + 1];
        System.arraycopy(array, 0, updateArray, 0, array.length);
        updateArray[array.length] = element;
        return updateArray;
    }

    private static int[] findIndexesGuessLetterInHiddenWord(Word word, Answer answer) {
        String hiddenWord = word.getHiddenWord();
        int[] arrayOfIndexes = new int[0];
        char[] arrayOfLetters = hiddenWord.toCharArray();
        int arrayOfLettersLength = arrayOfLetters.length;
        for (int i = 0; i < arrayOfLettersLength; ++i) {
            if (arrayOfLetters[i] == answer.getAnswerLetter()) {
                arrayOfIndexes = appendElementInArray(arrayOfIndexes, i);
            }
        }
        return arrayOfIndexes;
    }

    public static void openGuessedLettersInEncryptedWord(Word word, Answer answer) {
        int[] arrayOfIndexes = findIndexesGuessLetterInHiddenWord(word, answer);
        String encryptedWord = word.getEncryptedWord();
        char[] encryptedWordLetters = encryptedWord.toCharArray();
        for (int i : arrayOfIndexes) {
            encryptedWordLetters[i] = answer.getAnswerLetter();
        }
        String encryptedWordWithOpenLetters = new String(encryptedWordLetters);
        word.setEncryptedWord(encryptedWordWithOpenLetters);
    }
}
