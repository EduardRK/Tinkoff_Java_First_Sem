package edu.hw8.Task1;

import java.util.HashMap;
import java.util.Map;

public final class KeyWords {
    public static final Map<String, String> KEY_WORDS = new HashMap<>();

    static {
        KEY_WORDS.put("личности", "Не переходи на личности там, где их нет");
        KEY_WORDS.put(
            "оскорбления",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
        );
        KEY_WORDS.put(
            "глупый",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма."
        );
        KEY_WORDS.put("интеллект", "Чем ниже интеллект, тем громче оскорбления");
    }

    private KeyWords() {
    }
}
