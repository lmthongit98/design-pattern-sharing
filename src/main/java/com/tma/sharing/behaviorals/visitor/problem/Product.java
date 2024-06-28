package com.tma.sharing.behaviorals.visitor.problem;

public abstract class Product {

    protected double price;

    public Product(double price) {
        this.price = price;
    }

    public abstract double applySeasonalDiscount();

    public double getPrice() {
        return price;
    }
}
