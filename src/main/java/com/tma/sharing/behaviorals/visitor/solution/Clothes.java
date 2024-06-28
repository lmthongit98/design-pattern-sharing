package com.tma.sharing.behaviorals.visitor.solution;

public class Clothes extends Product {

    public Clothes(double price) {
        super(price);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
