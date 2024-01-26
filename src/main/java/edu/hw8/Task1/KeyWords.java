package edu.hw8.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public final class KeyWords {
    private static final List<String> KEY_WORDS = new ArrayList<>();

    static {
        KEY_WORDS.add("Не переходи на личности там, где их нет");
        KEY_WORDS.add("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        KEY_WORDS.add(
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        KEY_WORDS.add("Чем ниже интеллект, тем громче оскорбления");
    }

    public KeyWords() {
    }

    public @NotNull Optional<String> answerByKeyWord(String keyWord) {
        return KEY_WORDS.stream()
            .filter(string -> string.lines().anyMatch(string1 -> string1.equals(keyWord)))
            .findFirst();
    }
}
