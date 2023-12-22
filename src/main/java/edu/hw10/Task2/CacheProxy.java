package edu.hw10.Task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class CacheProxy implements InvocationHandler {
    private static final String CACHE_EXTENSION = ".cache";
    private final Path dir;
    private final Object classObject;
    private final Map<Method, Map<Object, Object>> cache;

    private CacheProxy(Object classObject, Path dir) {
        this.dir = dir;
        this.classObject = classObject;
        this.cache = new HashMap<>();
    }

    public static @NotNull Object create(@NotNull Object classObject, Path dir) {
        return Proxy.newProxyInstance(
            classObject.getClass().getClassLoader(),
            classObject.getClass().getInterfaces(),
            new CacheProxy(classObject, dir)
        );
    }

    public static @NotNull Object create(Object classObject) {
        return create(classObject, null);
    }

    @Override
    public Object invoke(Object proxy, @NotNull Method method, Object[] args) throws Throwable {
        Annotation[] annotations = method.getAnnotations();
        Annotation cacheAnnotation = Arrays.stream(annotations)
            .filter(annotation -> annotation instanceof Cache)
            .findFirst()
            .orElse(null);

        if (cacheAnnotation == null) {
            return method.invoke(classObject, args);
        }

        Map<Object, Object> result = new HashMap<>(Map.of(
            args, method.invoke(classObject, args)
        ));

        boolean flag = ((Cache) cacheAnnotation).persist();
        if (flag) {
            saveInFile(method, result);
        } else {
            saveInCache(method, result);
        }

        return cache.get(method).get(args);
    }

    private void saveInFile(Method method, Map<Object, Object> result) {
        try {
            cache.put(method, result);
            Path filePath = getSavePath(method, dir);

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath.toFile()))) {
                for (Object key : result.keySet()) {
                    outputStream.writeObject(key);
                    outputStream.writeObject(result.get(key));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path getSavePath(@NotNull Method method, @NotNull Path path) {
        File[] files = path.toFile().listFiles();
        Path newPath = Path.of(dir.toString() + File.separator + method.getName() + CACHE_EXTENSION);

        if (files != null) {
            Set<File> fileSet = new HashSet<>(Set.of(files));
            int i = 1;
            while (true) {
                newPath = Path.of(dir + File.separator + method.getName() + "_" + i + CACHE_EXTENSION);
                if (!fileSet.contains(newPath.toFile())) {
                    return newPath;
                }
                ++i;
            }
        }
        return newPath;
    }

    private void saveInCache(Method method, Map<Object, Object> result) {
        cache.put(method, result);
    }
}
