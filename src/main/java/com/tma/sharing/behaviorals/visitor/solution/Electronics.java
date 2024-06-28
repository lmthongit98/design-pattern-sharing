package com.tma.sharing.behaviorals.visitor.solution;

public class Electronics extends Product {

    public Electronics(double price) {
        super(price);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
