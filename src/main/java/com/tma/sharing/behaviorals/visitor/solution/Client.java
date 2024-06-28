package com.tma.sharing.behaviorals.visitor.solution;


import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Clothes(50),
                new Electronics(100),
                new Groceries(20)
        );

        SeasonalDiscountVisitor visitor = new SeasonalDiscountVisitor();

        for (Product product: products) {
            product.accept(visitor);
        }

        System.out.println("Discounted price: " + visitor.getDiscountedPrice());


    }

}
