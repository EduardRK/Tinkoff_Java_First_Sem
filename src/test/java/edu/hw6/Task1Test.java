package edu.hw6;

import edu.hw6.Task1.DiskMap;
import java.io.BufferedReader;
import java.io.FileReader;
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
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;

public class Task1Test {
    @Nested
    @DisplayName("Creating diskMap with only directory name") class DiskMapWithOnlyDirectory {
        @Test
        @DisplayName("Test methods")
        public void testMethods(@TempDir(cleanup = CleanupMode.ALWAYS) Path dir) throws IOException {
            dir.toFile().mkdirs();
            Map<String, String> diskMap = new DiskMap(dir.toString());

            Assertions.assertTrue(diskMap.isEmpty());

            Path pathKey = Path.of(dir + "/Key");
            Assertions.assertTrue(Files.notExists(pathKey));
            diskMap.put("Key", "Value");
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathKey.toFile()))) {
                Assertions.assertEquals("Key:Value", bufferedReader.readLine());
            }

            Assertions.assertEquals(1, diskMap.size());

            Assertions.assertTrue(diskMap.containsKey("Key"));
            Assertions.assertFalse(diskMap.containsKey("Lol"));

            Assertions.assertTrue(diskMap.containsValue("Value"));
            Assertions.assertFalse(diskMap.containsValue("Kek"));

            Assertions.assertEquals("Value", diskMap.get("Key"));
            Assertions.assertNull(diskMap.get("Da"));

            diskMap.remove("Key");
            Assertions.assertTrue(Files.notExists(pathKey));

            Map<String, String> map = new HashMap<>(Map.of(
                "Key1", "Value1",
                "Key2", "Value2",
                "Key3", "Value3",
                "Key4", "Value4"
            ));
            diskMap.putAll(map);
            Set<String> keySet = new HashSet<>(Set.of(
                "Key1",
                "Key2",
                "Key3",
                "Key4"
            ));
            Collection<String> values = new ArrayList<>(List.of(
                "Value1",
                "Value2",
                "Value3",
                "Value4"
            ));
            Assertions.assertEquals(keySet, diskMap.keySet());
            Assertions.assertTrue(diskMap.values().containsAll(values));

            Assertions.assertEquals(map.entrySet(), diskMap.entrySet());

            diskMap.clear();
            for (String key : keySet) {
                Assertions.assertTrue(Files.notExists(Path.of(dir + "/" + key)));
            }
        }
    }

    @Nested
    @DisplayName("Creating diskMap with directory name and other map") class DiskMapWithDirectoryAndOtherMap {
        @Test
        @DisplayName("Test methods")
        public void testMethods(@TempDir(cleanup = CleanupMode.ALWAYS) Path dir) throws IOException {
            dir.toFile().mkdirs();
            Map<String, String> otherMap = new HashMap<>(Map.of(
                "Key1", "Value1",
                "Key2", "Value2",
                "Key3", "Value3"
            ));
            Map<String, String> diskMap = new DiskMap(otherMap, dir.toString());

            Assertions.assertFalse(diskMap.isEmpty());

            Path pathKey = Path.of(dir + "/Key");
            Assertions.assertTrue(Files.notExists(pathKey));
            diskMap.put("Key", "Value");
            Assertions.assertTrue(Files.exists(pathKey));
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathKey.toFile()))) {
                Assertions.assertEquals("Key:Value", bufferedReader.readLine());
            }

            Assertions.assertEquals(4, diskMap.size());

            Assertions.assertTrue(diskMap.containsKey("Key"));
            Assertions.assertFalse(diskMap.containsKey("Lol"));

            Assertions.assertTrue(diskMap.containsValue("Value"));
            Assertions.assertFalse(diskMap.containsValue("Kek"));

            Assertions.assertEquals("Value", diskMap.get("Key"));
            Assertions.assertNull(diskMap.get("Da"));

            diskMap.remove("Key");
            Assertions.assertTrue(Files.notExists(pathKey));

            Map<String, String> map = new HashMap<>(Map.of(
                "Key4", "Value4",
                "Key5", "Value5",
                "Key6", "Value6",
                "Key7", "Value7"
            ));
            map.putAll(otherMap);

            diskMap.putAll(map);
            Set<String> keySet = new HashSet<>(Set.of(
                "Key1",
                "Key2",
                "Key3",
                "Key4",
                "Key5",
                "Key6",
                "Key7"
            ));
            Collection<String> values = new ArrayList<>(List.of(
                "Value1",
                "Value2",
                "Value3",
                "Value4",
                "Value5",
                "Value6",
                "Value7"
            ));
            Assertions.assertEquals(keySet, diskMap.keySet());
            Assertions.assertTrue(diskMap.values().containsAll(values));

            Assertions.assertEquals(map.entrySet(), diskMap.entrySet());

            diskMap.clear();
            for (String key : keySet) {
                Assertions.assertTrue(Files.notExists(Path.of(dir + "/" + key)));
            }
        }
    }

    @Nested
    @DisplayName("Read diskMap from other file") class DiskMapReadFile {
        @Test
        @DisplayName("Test methods")
        public void testMethods(@TempDir(cleanup = CleanupMode.ALWAYS) Path dir) {
            dir.toFile().mkdirs();
            {
                Map<String, String> otherMap = new HashMap<>(Map.of(
                    "Key1", "Value1",
                    "Key2", "Value2",
                    "Key3", "Value3"
                ));
                Map<String, String> diskMap = new DiskMap(otherMap, dir.toString());
            }

            Map<String, String> diskMap = new DiskMap(dir.toString(), true);
            Assertions.assertEquals("Value1", diskMap.get("Key1"));
            Assertions.assertEquals("Value2", diskMap.get("Key2"));
            Assertions.assertEquals("Value3", diskMap.get("Key3"));

            diskMap.remove("Key1");
            Assertions.assertTrue(Files.notExists(Path.of(dir + "/Key1")));
        }
    }
}
