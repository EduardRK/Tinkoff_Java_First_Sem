package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final static Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages(String command) throws Exception {
        try {
            tryExecute(command);
        } catch (Exception e) {
            LOGGER.info("Update failed");
        }
    }

    private void tryExecute(String command) throws Exception {
        Connection successConnection = null;
        Exception exception = new Exception();

        for (int i = 0; i < maxAttempts; ++i) {
            try {
                successConnection = manager.getConnection();
                if (successConnection != null) {
                    successConnection.execute(command);
                    successConnection.close();
                    return;
                }
            } catch (Exception e) {
                exception = new Exception(e.getCause());
            }
        }
        throw exception;
    }
}

