package edu.hw3;

import edu.hw3.task7.AddNullTreeMapComparator;
import java.util.Comparator;
import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {
    @Test
    @DisplayName("Add null key in TreeMap")
    public void addNullKeyInTreeMap() {
        Comparator<? super String> treeMapComparator = new AddNullTreeMapComparator();
        TreeMap<String, String> treeMap = new TreeMap<>(treeMapComparator);
        treeMap.put(null, "test");
        Assertions.assertTrue(treeMap.containsKey(null));
        Assertions.assertEquals(treeMap.get(null), "test");
        
        treeMap.put("first", "test other");
        Assertions.assertTrue(treeMap.containsKey("first"));
        Assertions.assertEquals(treeMap.get("first"), "test other");
    }
}
