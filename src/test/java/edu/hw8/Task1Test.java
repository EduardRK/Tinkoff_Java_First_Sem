package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Task1Test {
    private static final int PORT = 8080;
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
        .availableProcessors());

    @ParameterizedTest
    @CsvSource(value = {
        "личности, Не переходи на личности там, где их нет",
        "оскорбления, Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "глупый, А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект, Чем ниже интеллект, тем громче оскорбления"
    })
    @DisplayName("Test single request")
    public void singleRequest(String request, String expectedResponse) throws InterruptedException {
        Server server = new Server(PORT);
        Client client = new Client(PORT);

        Thread thread = new Thread(server::work);
        thread.start();
        Thread.sleep(1000);

        executorService.submit(() -> Assertions.assertEquals(client.getResponse(request), expectedResponse));
        executorService.shutdown();

        server.stopWork();
    }

    @Test
    @DisplayName("Test multi request")
    public void multiRequest() throws InterruptedException {
        List<String> words = new ArrayList<>(List.of("личности", "оскорбления", "глупый", "интеллект", "wrong"));
        List<String> responses = new CopyOnWriteArrayList<>();
        Set<String> responsesSet = new HashSet<>(Set.of(
            "Не переходи на личности там, где их нет",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
            "Чем ниже интеллект, тем громче оскорбления",
            "На это ответить нечего"
        ));

        Server server = new Server(PORT);
        Thread thread = new Thread(server::work);
        thread.start();
        Thread.sleep(1000);

        for (int i = 0; i < 100; ++i) {
            executorService.submit(() -> {
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                Client client = new Client(PORT);
                String response = client.getResponse(words.get(threadLocalRandom.nextInt(words.size())));
                responses.add(response);
            });
        }

        executorService.close();
        server.stopWork();

        for (String string : responses) {
            Assertions.assertTrue(responsesSet.contains(string));
        }

        Assertions.assertEquals(100, responses.size());
    }
}
