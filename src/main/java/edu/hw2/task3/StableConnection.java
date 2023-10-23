package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    public StableConnection() {
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
