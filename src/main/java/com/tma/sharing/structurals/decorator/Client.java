package com.tma.sharing.structurals.decorator;

public class Client {

    public static void main(String[] args) {
        boolean isDbLoggerEnable = true;
        boolean isEmailLoggerEnable = true;
        Logger logger = new FileLogger();
        if (isDbLoggerEnable) {
            logger = new DatabaseLogger(logger);
        }
        if (isEmailLoggerEnable) {
            logger = new EmailLogger(logger);
        }
        logger.log("There was some error!");
    }

}
