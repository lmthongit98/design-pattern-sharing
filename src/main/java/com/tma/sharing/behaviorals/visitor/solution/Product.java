package com.tma.sharing.behaviorals.visitor.solution;

public abstract class Product {

    protected double price;

    public Product(double price) {
        this.price = price;
    }



    public abstract void accept(Visitor visitor);

    public double getPrice() {
        return price;
    }

}
