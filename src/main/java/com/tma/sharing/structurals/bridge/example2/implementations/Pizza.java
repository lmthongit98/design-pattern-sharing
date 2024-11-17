package com.tma.sharing.structurals.bridge.example2.implementations;

public abstract class Pizza {
    protected String sauce;
    protected String toppings;
    protected String crust;

    public abstract void assemble();
    public abstract void qualityCheck();

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }
}
