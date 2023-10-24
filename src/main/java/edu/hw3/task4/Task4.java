package edu.hw3.task4;

import edu.hw3.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Task4 {
    private Task4() {
    }

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

    private static final HashMap<Integer, String> ROMAN_DIGITS = new HashMap<>() {{
        put(I_IN_DECIMAL, "I");
        put(IV_IN_DECIMAL, "IV");
        put(V_IN_DECIMAL, "V");
        put(IX_IN_DECIMAL, "IX");
        put(X_IN_DECIMAL, "X");
        put(XL_IN_DECIMAL, "XL");
        put(L_IN_DECIMAL, "L");
        put(XC_IN_DECIMAL, "XC");
        put(C_IN_DECIMAL, "C");
        put(CD_IN_DECIMAL, "CD");
        put(D_IN_DECIMAL, "D");
        put(CM_IN_DECIMAL, "CM");
        put(M_IN_DECIMAL, "M");
    }};

    public static String convertToRoman(int number) throws InvalidArgumentException {
        if (!Validator.isPositiveNumber(number)) {
            throw new InvalidArgumentException();
        }

        int modifiedNumber = number;
        ArrayList<Integer> keyArray = new ArrayList<>(ROMAN_DIGITS.keySet());
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

        return new String(romanNumber);
    }
}
