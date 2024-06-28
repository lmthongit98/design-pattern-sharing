package com.tma.sharing.behaviorals.visitor.problem;

public class Clothes extends Product {

    public Clothes(double price) {
        super(price);
    }

    @Override
    public double applySeasonalDiscount() {
        System.out.println("Applying seasonal discount for Clothes");
        return price * 0.20;
    }

}
