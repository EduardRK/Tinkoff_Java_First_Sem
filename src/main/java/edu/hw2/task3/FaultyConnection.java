package edu.hw2.task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private final int numberShouldBeSuccessfulConnections = 3;

    public FaultyConnection() throws Exception {
        int possibilityConnect = new Random().nextInt(numberShouldBeSuccessfulConnections);
        if (possibilityConnect % numberShouldBeSuccessfulConnections != 0) {
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
