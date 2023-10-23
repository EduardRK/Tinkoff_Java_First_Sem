package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() throws Exception {
        int typeConnection = new Random().nextInt(2);
        return (typeConnection % 2 == 0) ? new StableConnection() : new FaultyConnection();
    }
}
