package com.tma.sharing.behaviorals.visitor.solution;

public interface Visitor {
    void visit(Electronics electronics);
    void visit(Groceries groceries);
    void visit(Clothes clothes);
}
