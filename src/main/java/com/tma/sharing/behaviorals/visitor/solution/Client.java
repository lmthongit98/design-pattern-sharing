package com.tma.sharing.behaviorals.visitor.solution;


import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Clothes(50),
                new Electronics(100),
                new Groceries(20)
        );

        double discountedPrice = 0;

        DiscountService discountService = new DiscountService();

        for(Product product : products) {
            if (product instanceof Clothes clothes) {
                discountedPrice += discountService.applySeasonalDiscount(clothes);
            } else if (product instanceof Groceries groceries) {
                discountedPrice += discountService.applySeasonalDiscount(groceries);
            } else if (product instanceof Electronics electronics) {
                discountedPrice += discountService.applySeasonalDiscount(electronics);
            }
        }

        System.out.println("Discounted price: " + discountedPrice);


    }

}
