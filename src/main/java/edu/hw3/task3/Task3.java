package edu.hw3.task3;

import edu.hw3.Validator;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static Map<Object, Integer> freqDict(Object[] objectsArray) {
        if (Validator.isArrayNull(objectsArray)) {
            return null;
        }
        Map<Object, Integer> frequencyDictionary = new HashMap<>();
        if (Validator.isArrayEmpty(objectsArray)) {
            return frequencyDictionary;
        }

        for (var object : objectsArray) {
            frequencyDictionary.put(object, frequencyDictionary.getOrDefault(object, 0) + 1);
        }
        return frequencyDictionary;
    }
}
