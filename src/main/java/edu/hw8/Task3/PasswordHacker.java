package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;

public class PasswordHacker {
    private static final int COUNT_THREADS = Runtime.getRuntime().availableProcessors();
    private static final List<String> ALPHABET = new ArrayList<>();

    static {
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] alphabetChars = alphabet.toCharArray();
        for (char c : alphabetChars) {
            ALPHABET.add(String.valueOf(c));
        }
    }

    private final ConcurrentMap<String, String> encryptedPasswords = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, String> decryptedPasswords = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

    public PasswordHacker(@NotNull List<String> stringList) {
        for (String string : stringList) {
            List<String> parseList = Parser.parse(string);
            encryptedPasswords.put(parseList.get(1), parseList.get(0));
        }
    }

    public PasswordHacker(String... strings) {
        this(List.of(strings));
    }

    public void hackingPasswords() {
        try {
            executorService.invokeAll(getTasks());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        executorService.close();
    }

    public Map<String, String> getDecryptedPasswords() {
        return decryptedPasswords;
    }

    private @NotNull List<Callable<Boolean>> getTasks() {
        final int alphabetSize = ALPHABET.size();
        final int shift = alphabetSize / COUNT_THREADS;
        final int countIterations = alphabetSize - 2 * shift;
        List<Callable<Boolean>> list = new ArrayList<>();

        int i = 0;
        for (; i < countIterations; i += shift) {
            int finalI = i;
            list.add(() -> {
                String tempPassword = ALPHABET.get(finalI);
                String tempHash;

                while (!encryptedPasswords.keySet().isEmpty()) {
                    tempPassword =
                        getNextPasswordInRange(tempPassword, ALPHABET.get(finalI), ALPHABET.get(finalI + shift));
                    tempHash = getMD5Hash(tempPassword);

                    if (encryptedPasswords.containsKey(tempHash)) {
                        decryptedPasswords.put(encryptedPasswords.remove(tempHash), tempPassword);
                    }
                }
                return true;
            });
        }

        int finalI1 = i;
        list.add(() -> {
            String tempPassword = ALPHABET.get(finalI1);
            String tempHash;

            while (!encryptedPasswords.keySet().isEmpty()) {
                tempPassword =
                    getNextPasswordInRange(tempPassword, ALPHABET.get(finalI1), ALPHABET.get(finalI1 + shift + 1));
                tempHash = getMD5Hash(tempPassword);

                if (encryptedPasswords.containsKey(tempHash)) {
                    decryptedPasswords.put(encryptedPasswords.remove(tempHash), tempPassword);
                }
            }
            return true;
        });

        return list;
    }

    private String getNextPasswordInRange(@NotNull String password, String startSymbol, String endSymbol) {
        String endPassword = String.valueOf(endSymbol).repeat(password.length());

        if (!password.equals(endPassword)) {
            return getNextPassword(password);
        }
        return startSymbol.repeat(password.length() + 1);
    }

    private String getNextPassword(@NotNull String startPassword) {
        char[] charsPasswordArray = startPassword.toCharArray();
        int charsPasswordArrayLength = charsPasswordArray.length;
        char[] endPassword = "z".repeat(charsPasswordArrayLength).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        char currentChar;
        for (int i = charsPasswordArrayLength - 1; i >= 0; --i) {
            currentChar = charsPasswordArray[i];
            charsPasswordArray[i] = getNextSymbol(currentChar);
            if (currentChar != 'z') {
                return stringBuilder.append(charsPasswordArray).toString();
            } else if (Arrays.equals(endPassword, charsPasswordArray)) {
                break;
            }
        }

        return "0".repeat(charsPasswordArrayLength + 1);
    }

    private @NotNull String getMD5Hash(@NotNull String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private char getNextSymbol(char symbol) {
        return switch (symbol) {
            case '9' -> 'A';
            case 'Z' -> 'a';
            case 'z' -> '0';
            default -> (char) (symbol + 1);
        };
    }
}
