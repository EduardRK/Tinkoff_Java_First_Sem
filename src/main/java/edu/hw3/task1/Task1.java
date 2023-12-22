package edu.hw3.task1;

public final class Task1 {
    private static final int ASCII_CODE_FIRST_UPPER_CASE_LETTER = 65;
    private static final int ASCII_CODE_LAST_UPPER_CASE_LETTER = 90;
    private static final int ASCII_CODE_FIRST_LOWER_CASE_LETTER = 97;
    private static final int ASCII_CODE_LAST_LOWER_CASE_LETTER = 122;

    private Task1() {
    }

    public static String atbash(String message) {
        if (message == null || message.isEmpty()) {
            return message;
        }

        char[] messageCharArray = message.toCharArray();
        char[] encodeMessageCharArray = new char[messageCharArray.length];
        char messageCharArrayItem;

        for (int i = 0; i < messageCharArray.length; ++i) {
            messageCharArrayItem = messageCharArray[i];

            if (isUpperCaseLetter(messageCharArrayItem)) {
                encodeMessageCharArray[i] = encodeUpperCaseLetter(messageCharArrayItem);
            } else if (isLowerCaseLetter(messageCharArrayItem)) {
                encodeMessageCharArray[i] = encodeLowerCaseLetter(messageCharArrayItem);
            } else {
                encodeMessageCharArray[i] = messageCharArrayItem;
            }
        }

        return new String(encodeMessageCharArray);
    }

    private static boolean isUpperCaseLetter(char letter) {
        return (int) letter >= ASCII_CODE_FIRST_UPPER_CASE_LETTER
            && (int) letter <= ASCII_CODE_LAST_UPPER_CASE_LETTER;
    }

    private static boolean isLowerCaseLetter(char letter) {
        return (int) letter >= ASCII_CODE_FIRST_LOWER_CASE_LETTER
            && (int) letter <= ASCII_CODE_LAST_LOWER_CASE_LETTER;
    }

    private static char encodeUpperCaseLetter(char upperCaseLetter) {
        return (char) (ASCII_CODE_LAST_UPPER_CASE_LETTER
            - ((int) upperCaseLetter - ASCII_CODE_FIRST_UPPER_CASE_LETTER));
    }

    private static char encodeLowerCaseLetter(char lowerCaseLetter) {
        return (char) (ASCII_CODE_FIRST_LOWER_CASE_LETTER
            - ((int) lowerCaseLetter - ASCII_CODE_LAST_LOWER_CASE_LETTER));
    }
}
