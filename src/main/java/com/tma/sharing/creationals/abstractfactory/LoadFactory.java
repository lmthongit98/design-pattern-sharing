package com.tma.sharing.creationals.abstractfactory;

public class LoadFactory {
    public static MobileFactory load(String type) {
        return switch (type) {
            case "3g" -> new Mobile3GFactory();
            case "4g" -> new Mobile4GFactory();
            default -> throw new IllegalArgumentException("Type is not supported!");
        };
    }
}
