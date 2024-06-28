package com.tma.sharing.behaviorals.visitor.problem;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Clothes(50),
                new Electronics(100),
                new Groceries(20)
        );

        double discountedPrice = 0;

        for(Product product : products) {
            discountedPrice += product.applySeasonalDiscount();
        }

        System.out.println("Discounted price: " + discountedPrice);

    }

}
