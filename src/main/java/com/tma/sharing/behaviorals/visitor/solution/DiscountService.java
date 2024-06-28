package com.tma.sharing.behaviorals.visitor.solution;

import com.tma.sharing.behaviorals.visitor.problem.Product;

public class DiscountService {

   public double applySeasonalDiscount(Electronics electronic) {
       System.out.println("Applying seasonal discount for Electronic");
       return electronic.getPrice() * 0.10;
   }

    public double applySeasonalDiscount(Clothes clothe) {
        System.out.println("Applying seasonal discount for Clothes");
        return clothe.getPrice() * 0.20;
    }

    public double applySeasonalDiscount(Groceries grocery) {
        System.out.println("Applying seasonal discount for Groceries");
        return grocery.getPrice() * 0.50;
    }

}
