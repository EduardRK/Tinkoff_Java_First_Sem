package edu.hw3;

import edu.hw3.task7.AddNullTreeMapComparator;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

public class Task7Test {
    @ParameterizedTest
    @NullSource
    @DisplayName("Add null key in TreeMap")
    public void addNullKeyInTreeMap(String key) {
        Comparator<? super String> treeMapComparator = new AddNullTreeMapComparator();
        Map<String, String> treeMap = new TreeMap<>(treeMapComparator);

        treeMap.put(key, "test");
        Assertions.assertTrue(treeMap.containsKey(key));
        Assertions.assertEquals("test", treeMap.get(key));

        treeMap.put("first", "test other");
        Assertions.assertTrue(treeMap.containsKey("first"));
        Assertions.assertEquals("test other", treeMap.get("first"));
    }
}
