package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ExecutorService executorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final int port;
    private final boolean isWork = true;

    public Server(int port) {
        this.port = port;
    }

    public void work() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (isWork) {
                try {
                    Socket socket = serverSocket.accept();
                    executorService.submit(() -> {
                        try (
                            BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(socket.getInputStream())
                            );
                            BufferedWriter bufferedWriter = new BufferedWriter(
                                new OutputStreamWriter(socket.getOutputStream())
                            )
                        ) {

                            String request = bufferedReader.readLine();

                            bufferedWriter.write(KeyWords.KEY_WORDS.getOrDefault(request, "На это ответить нечего"));
                            bufferedWriter.newLine();
                            bufferedWriter.flush();

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (IOException ignored) {
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}

