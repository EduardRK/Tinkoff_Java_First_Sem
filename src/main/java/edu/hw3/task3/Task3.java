package edu.hw3.task3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static Map<Object, Integer> freqDict(Object[] objectsArray) {
        if (objectsArray == null) {
            return null;
        }

        Map<Object, Integer> frequencyDictionary = new HashMap<>();

        for (Object object : objectsArray) {
            frequencyDictionary.put(object, frequencyDictionary.getOrDefault(object, 0) + 1);
        }

        return frequencyDictionary;
    }
}
