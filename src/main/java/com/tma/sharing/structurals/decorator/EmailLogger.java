package com.tma.sharing.structurals.decorator;

public class EmailLogger extends LoggerDecorator {

    public EmailLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        super.logger.log(message);
        System.out.println("Logged to Email with message: " + message);
    }

}
