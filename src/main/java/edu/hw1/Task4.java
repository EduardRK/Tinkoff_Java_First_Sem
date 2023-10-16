package edu.hw1;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String brokeStr) {
        if (Validator.isStringEmpty(brokeStr)) {
            return brokeStr;
        }

        char[] brokeStrArray = brokeStr.toCharArray();
        int brokeStrArrayLength = brokeStr.length();
        for (int i = 1; i < brokeStrArrayLength; i += 2) {
            Utility.swap(brokeStrArray, i - 1, i);
        }
        return new String(brokeStrArray);
    }
}
