package edu.hw3.task3;

import edu.hw3.Validator;
import java.util.HashMap;

public class Task3 {
    private Task3() {
    }

    public static HashMap<Object, Integer> freqDict(Object[] objectsArray) {
        if (Validator.isArrayNull(objectsArray)) {
            return null;
        }
        HashMap<Object, Integer> frequencyDictionary = new HashMap<>();
        if (Validator.isArrayEmpty(objectsArray)) {
            return frequencyDictionary;
        }

        for (var object : objectsArray) {
            if (frequencyDictionary.containsKey(object)) {
                frequencyDictionary.put(object, frequencyDictionary.get(object) + 1);
            } else {
                frequencyDictionary.put(object, 1);
            }
        }
        return frequencyDictionary;
    }
}
