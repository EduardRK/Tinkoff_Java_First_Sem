package edu.hw2.task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Random RANDOM = new Random();
    private static final int CHANCE_SUCCESSFUL_CONNECTIONS = 3;

    public FaultyConnection() throws Exception {
        if (RANDOM.nextInt(CHANCE_SUCCESSFUL_CONNECTIONS) % CHANCE_SUCCESSFUL_CONNECTIONS != 0) {
            throw new ConnectionException();
        }
    }

    @Override
    public void execute(String command) {
        LOGGER.info(command + " - complete");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection close");
    }
}
