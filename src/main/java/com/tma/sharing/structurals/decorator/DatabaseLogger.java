package com.tma.sharing.structurals.decorator;

public class DatabaseLogger extends LoggerDecorator {

    public DatabaseLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        super.logger.log(message);
        System.out.println("Logged to database with message: " + message);
    }

}
