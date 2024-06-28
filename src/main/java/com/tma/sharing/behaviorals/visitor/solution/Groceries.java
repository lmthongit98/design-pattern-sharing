package com.tma.sharing.behaviorals.visitor.solution;

public class Groceries extends Product {

    public Groceries(double price) {
        super(price);
    }

    @Override
    public void accept(Visitor visitor) { /// Seasonal Visitor , this: Groceries, visit(Groceries)
        visitor.visit(this);
    }


}
