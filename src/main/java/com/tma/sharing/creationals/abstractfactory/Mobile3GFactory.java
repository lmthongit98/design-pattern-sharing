package com.tma.sharing.creationals.abstractfactory;

public class Mobile3GFactory implements MobileFactory{
    @Override
    public Nokia createNokiaMobile() {
        return new Nokia3G();
    }

    @Override
    public Apple createAppleMobile() {
        return new Iphone3G();
    }
}
