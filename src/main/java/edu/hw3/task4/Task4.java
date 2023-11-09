package edu.hw3.task4;

import edu.hw3.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {

    private static final int I_IN_DECIMAL = 1;
    private static final int IV_IN_DECIMAL = 4;
    private static final int V_IN_DECIMAL = 5;
    private static final int IX_IN_DECIMAL = 9;
    private static final int X_IN_DECIMAL = 10;
    private static final int XL_IN_DECIMAL = 40;
    private static final int L_IN_DECIMAL = 50;
    private static final int XC_IN_DECIMAL = 90;
    private static final int C_IN_DECIMAL = 100;
    private static final int CD_IN_DECIMAL = 400;
    private static final int D_IN_DECIMAL = 500;
    private static final int CM_IN_DECIMAL = 900;
    private static final int M_IN_DECIMAL = 1000;

    private static final Map<Integer, String> ROMAN_DIGITS = new HashMap<>();

    static {
        ROMAN_DIGITS.put(I_IN_DECIMAL, "I");
        ROMAN_DIGITS.put(IV_IN_DECIMAL, "IV");
        ROMAN_DIGITS.put(V_IN_DECIMAL, "V");
        ROMAN_DIGITS.put(IX_IN_DECIMAL, "IX");
        ROMAN_DIGITS.put(X_IN_DECIMAL, "X");
        ROMAN_DIGITS.put(XL_IN_DECIMAL, "XL");
        ROMAN_DIGITS.put(L_IN_DECIMAL, "L");
        ROMAN_DIGITS.put(XC_IN_DECIMAL, "XC");
        ROMAN_DIGITS.put(C_IN_DECIMAL, "C");
        ROMAN_DIGITS.put(CD_IN_DECIMAL, "CD");
        ROMAN_DIGITS.put(D_IN_DECIMAL, "D");
        ROMAN_DIGITS.put(CM_IN_DECIMAL, "CM");
        ROMAN_DIGITS.put(M_IN_DECIMAL, "M");
    }

    private Task4() {
    }

    public static String convertToRoman(int number) {
        if (!Validator.isPositiveNumber(number)) {
            throw new IllegalArgumentException();
        }

        int modifiedNumber = number;
        List<Integer> keyArray = new ArrayList<>(ROMAN_DIGITS.keySet());
        Collections.sort(keyArray);
        int keyArrayLength = keyArray.size();
        StringBuilder romanNumber = new StringBuilder();
        int indexOfKey = keyArrayLength - 1;

        while (modifiedNumber > 0) {
            if (modifiedNumber >= keyArray.get(indexOfKey)) {
                romanNumber.append(ROMAN_DIGITS.get(keyArray.get(indexOfKey)));
                modifiedNumber -= keyArray.get(indexOfKey);
            } else {
                --indexOfKey;
            }
        }

        return romanNumber.toString();
    }
}
