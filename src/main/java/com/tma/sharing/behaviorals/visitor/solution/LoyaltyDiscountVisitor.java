package com.tma.sharing.behaviorals.visitor.solution;

public class LoyaltyDiscountVisitor implements Visitor {

    private double discountedPrice = 0;

    @Override
    public void visit(Electronics electronics) {
        System.out.println("Applying seasonal discount for Electronic");
        discountedPrice += electronics.getPrice() * 0.40;
    }

    @Override
    public void visit(Groceries groceries) {
        System.out.println("Applying seasonal discount for Groceries");
        discountedPrice += groceries.getPrice() * 0.60;
    }

    @Override
    public void visit(Clothes clothes) {
        System.out.println("Applying seasonal discount for Clothes");
        discountedPrice += clothes.getPrice() * 0.50;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

}
