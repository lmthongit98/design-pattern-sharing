package com.tma.sharing.creationals.abstractfactory;

public class Nokia3G implements Nokia{
    @Override
    public String getModelName() {
        return this.getClass().getName();
    }
}
