package com.tma.sharing.creationals.abstractfactory;

public class Client {
    public static void main(String[] args) {

        MobileFactory mobile3gFactory = LoadFactory.load("3g");
        Nokia nokia3g = mobile3gFactory.createNokiaMobile();
        Apple iphone3g = mobile3gFactory.createAppleMobile();
        System.out.println(nokia3g.getModelName());
        System.out.println(iphone3g.getModelName());

        MobileFactory mobile4gFactory = LoadFactory.load("4g");
        Nokia nokia4g = mobile4gFactory.createNokiaMobile();
        Apple iphone4g = mobile4gFactory.createAppleMobile();
        System.out.println(nokia4g.getModelName());
        System.out.println(iphone4g.getModelName());
    }
}
