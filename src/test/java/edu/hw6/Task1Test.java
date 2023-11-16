package edu.hw6;

import edu.hw6.Task1.DiskMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Nested @DisplayName("DiskMap with directory name") public class onlyDirName {
        private static final Path DIR_PATH = Path.of("Task1TestDirectory");

        @Test @DisplayName("Creation new DiskMap") public void creationNewDiskMap() throws IOException {
            Assertions.assertTrue(Files.notExists(DIR_PATH));

            Map<String, String> diskMap = new DiskMap(DIR_PATH.toString());
            Assertions.assertTrue(Files.exists(DIR_PATH));

            diskMap.clear();
            Files.delete(DIR_PATH);
        }

        @Test @DisplayName("Test methods") public void testPutAndGet() throws IOException {
            Path filePath = Path.of("Task1TestDirectory\\Key");
            Map<String, String> diskMap = new DiskMap(DIR_PATH.toString());

            Assertions.assertTrue(diskMap.isEmpty());

            Assertions.assertTrue(Files.notExists(filePath));
            diskMap.put("Key", "Value");
            Assertions.assertTrue(Files.exists(filePath));

            Assertions.assertTrue(diskMap.containsKey("Key"));
            Assertions.assertFalse(diskMap.containsKey("Key2"));

            Assertions.assertTrue(diskMap.containsValue("Value"));
            Assertions.assertFalse(diskMap.containsValue("Value2"));

            Assertions.assertEquals(1, diskMap.size());

            Assertions.assertEquals("Value", diskMap.get("Key"));

            Assertions.assertTrue(Files.exists(filePath));
            Assertions.assertEquals("Value", diskMap.remove("Key"));
            Assertions.assertTrue(Files.notExists(filePath));

            Map<String, String> map =
                new HashMap<>(Map.of("Key1", "Value1",
                    "Key2", "Value2",
                    "Key3", "Value3",
                    "Key4", "Value4"
                ));

            for (int i = 1; i < 5; ++i) {
                Path path = Path.of(DIR_PATH + "\\" + "Key" + i);
                Assertions.assertTrue(Files.notExists(path));
            }

            diskMap.putAll(map);

            for (int i = 1; i < 5; ++i) {
                Path path = Path.of(DIR_PATH + "\\" + "Key" + i);
                Assertions.assertTrue(Files.exists(path));
                Assertions.assertEquals("Value" + i, diskMap.get("Key" + i));
            }

            Set<String> set = new HashSet<>(Set.of("Key1", "Key2", "Key3", "Key4"));
            Set<String> keySet = diskMap.keySet();
            Assertions.assertEquals(set, keySet);

            for (int i = 1; i < 5; ++i) {
                Assertions.assertTrue(diskMap.containsValue("Value" + i));
            }

            Collection<String> list = new ArrayList<>(List.of("Value1", "Value2", "Value3", "Value4"));
            Collection<String> valueList = diskMap.values();
            Assertions.assertTrue(list.containsAll(valueList));

            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            Set<Map.Entry<String, String>> diskMapSet = diskMap.entrySet();
            Assertions.assertEquals(entrySet, diskMapSet);

            diskMap.clear();
            Files.delete(DIR_PATH);
        }
    }

    @Nested @DisplayName("DiskMap with directory name and map") public class dirNameAndMap {
        private static final Path DIR_PATH = Path.of("Task1TestDirectory");

        @Test @DisplayName("Creation new DiskMap") public void creationNewDiskMap() throws IOException {
            Assertions.assertTrue(Files.notExists(DIR_PATH));
            Map<String, String> map = new HashMap<>(Map.of("Key1", "Value1", "Key2", "Value2"));
            Map<String, String> diskMap = new DiskMap(map, DIR_PATH.toString());
            Assertions.assertTrue(Files.exists(DIR_PATH));
            Assertions.assertTrue(Files.exists(Path.of(DIR_PATH + "\\" + "Key1")));
            Assertions.assertTrue(Files.exists(Path.of(DIR_PATH + "\\" + "Key2")));

            diskMap.clear();
            Files.delete(DIR_PATH);
        }

        @Test @DisplayName("Test methods") public void testPutAndGet() throws IOException {
            Path filePath = Path.of("Task1TestDirectory\\Key");
            Map<String, String> map = new HashMap<>(Map.of("Key1", "Value1", "Key2", "Value2"));
            Map<String, String> diskMap = new DiskMap(map, DIR_PATH.toString());

            Assertions.assertFalse(diskMap.isEmpty());

            Assertions.assertTrue(Files.notExists(filePath));
            diskMap.put("Key", "Value");
            Assertions.assertTrue(Files.exists(filePath));

            Assertions.assertTrue(diskMap.containsKey("Key"));
            Assertions.assertTrue(diskMap.containsKey("Key1"));
            Assertions.assertTrue(diskMap.containsKey("Key2"));
            Assertions.assertFalse(diskMap.containsKey("Key4"));

            Assertions.assertTrue(diskMap.containsValue("Value"));
            Assertions.assertTrue(diskMap.containsValue("Value1"));
            Assertions.assertTrue(diskMap.containsValue("Value2"));
            Assertions.assertFalse(diskMap.containsValue("Value4"));

            Assertions.assertEquals(3, diskMap.size());

            Assertions.assertEquals("Value", diskMap.get("Key"));

            Assertions.assertTrue(Files.exists(filePath));
            Assertions.assertEquals("Value", diskMap.remove("Key"));
            Assertions.assertTrue(Files.notExists(filePath));

            Map<String, String> mapAdd =
                new HashMap<>(Map.of("Key5", "Value5",
                    "Key6", "Value6",
                    "Key3", "Value3",
                    "Key4", "Value4"
                ));

            for (int i = 3; i < 7; ++i) {
                Path path = Path.of(DIR_PATH + "\\" + "Key" + i);
                Assertions.assertTrue(Files.notExists(path));
            }

            diskMap.putAll(mapAdd);

            for (int i = 1; i < 7; ++i) {
                Path path = Path.of(DIR_PATH + "\\" + "Key" + i);
                Assertions.assertTrue(Files.exists(path));
                Assertions.assertEquals("Value" + i, diskMap.get("Key" + i));
            }

            Set<String> set = new HashSet<>(Set.of("Key1", "Key2", "Key3", "Key4", "Key5", "Key6"));
            Set<String> keySet = diskMap.keySet();
            Assertions.assertEquals(set, keySet);

            for (int i = 1; i < 7; ++i) {
                Assertions.assertTrue(diskMap.containsValue("Value" + i));
            }

            Collection<String> list =
                new ArrayList<>(List.of("Value1", "Value2", "Value3", "Value4", "Value5", "Value6"));
            Collection<String> valueList = diskMap.values();
            Assertions.assertTrue(list.containsAll(valueList));

            mapAdd.put("Key1", "Value1");
            mapAdd.put("Key2", "Value2");
            Set<Map.Entry<String, String>> entrySet = mapAdd.entrySet();
            Set<Map.Entry<String, String>> diskMapSet = diskMap.entrySet();
            Assertions.assertEquals(entrySet, diskMapSet);

            diskMap.clear();
            Files.delete(DIR_PATH);
        }
    }

    @Nested
    @DisplayName("DiskMap read from directory") public class DiskMapReadFromDirectory {
        private static final Path DIR_PATH = Path.of("hw6_TestsDirectory\\Task1TestRead");

        @Test
        @DisplayName("Read directory")
        public void readDirectory() {
            Assertions.assertTrue(Files.exists(DIR_PATH));
            Map<String, String> diskMap = new DiskMap(DIR_PATH.toString(), true);
            Assertions.assertTrue(Files.exists(DIR_PATH));
        }

        @Test
        @DisplayName("Test methods after read directory")
        public void testMethods() {
            Map<String, String> diskMap = new DiskMap(DIR_PATH.toString(), true);

            Assertions.assertEquals("Value", diskMap.get("Key"));
            Assertions.assertEquals("Value1", diskMap.get("Key1"));
            Assertions.assertEquals("Value2", diskMap.get("Key2"));

            Assertions.assertEquals(3, diskMap.size());

            Assertions.assertFalse(diskMap.isEmpty());

            Path path = Path.of(DIR_PATH + "\\" + "Key4");
            Assertions.assertTrue(Files.notExists(path));
            diskMap.put("Key4", "Value4");
            Assertions.assertTrue(Files.exists(path));

            Set<String> set = new HashSet<>(Set.of("Key", "Key1", "Key2", "Key4"));
            Set<String> keySet = diskMap.keySet();
            Assertions.assertEquals(set, keySet);

            Assertions.assertEquals("Value4", diskMap.get("Key4"));

            diskMap.remove("Key4");
            Assertions.assertTrue(Files.notExists(path));
        }
    }
}
