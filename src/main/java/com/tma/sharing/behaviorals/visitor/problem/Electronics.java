package com.tma.sharing.behaviorals.visitor.problem;

public class Electronics extends Product {

    public Electronics(double price) {
        super(price);
    }

    @Override
    public double applySeasonalDiscount() {
        System.out.println("Applying seasonal discount for Electronic");
        return price * 0.10;
    }

}
