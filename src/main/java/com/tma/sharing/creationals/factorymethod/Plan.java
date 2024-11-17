package com.tma.sharing.creationals.factorymethod;

public abstract class Plan {
    protected abstract double getRate();

    public double calculateBillAmount(int units) {
        return units * getRate();
    }
}
