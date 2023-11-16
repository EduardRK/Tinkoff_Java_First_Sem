package edu.hw6.Task1;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private static final String KEY_VALUE_FORMAT = "^(.+):(.+)$";
    private final String dirName;
    private final Map<String, String> bufferMap;
    private final Directory directory;

    public DiskMap(Map<String, String> map, String dirName) {
        this.dirName = dirName;
        bufferMap = new HashMap<>(map);
        directory = new DirectoryManager(dirName);

        for (String key : map.keySet()) {
            directory.writeFile(Path.of(dirName + "\\" + key), map.get(key));
        }
    }

    public DiskMap(String dirName) {
        this(new HashMap<>(), dirName);
    }

    public DiskMap(String dirName, boolean read) {
        this.dirName = dirName;
        bufferMap = new HashMap<>();
        directory = new DirectoryManager(dirName);

        if (read) {
            File dir = new File(dirName);
            File[] files = Objects.requireNonNull(dir.listFiles());

            for (File file : files) {
                String date = directory.readFile(file.toPath());
                Matcher matcher = Pattern.compile(KEY_VALUE_FORMAT).matcher(date);

                if (matcher.find()) {
                    bufferMap.put(matcher.group(1), matcher.group(2));
                }
            }
        }
    }

    @Override
    public int size() {
        return bufferMap.size();
    }

    @Override
    public boolean isEmpty() {
        return bufferMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return bufferMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return bufferMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return bufferMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        directory.writeFile(Path.of(dirName + "\\" + key), value);
        return bufferMap.put(key, value);
    }

    @Override
    public String remove(Object key) {
        directory.deleteFile((String) key);
        return bufferMap.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        for (String key : m.keySet()) {
            directory.writeFile(Path.of(dirName + "\\" + key), m.get(key));
        }
        bufferMap.putAll(m);
    }

    @Override
    public void clear() {
        directory.clearDirectory();
        bufferMap.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return bufferMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return bufferMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return bufferMap.entrySet();
    }
}
