package com.tma.sharing.behaviorals.visitor.problem;

public class Groceries extends Product {

    public Groceries(double price) {
        super(price);
    }

    @Override
    public double applySeasonalDiscount() {
        System.out.println("Applying seasonal discount for Groceries");
        return price * 0.50;
    }

}
