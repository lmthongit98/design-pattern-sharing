package com.tma.sharing.structurals.bridge.example2;

import com.tma.sharing.structurals.bridge.example2.abstractions.AmericanRestaurant;
import com.tma.sharing.structurals.bridge.example2.abstractions.ItalianRestaurant;
import com.tma.sharing.structurals.bridge.example2.abstractions.Restaurant;
import com.tma.sharing.structurals.bridge.example2.implementations.PepperoniPizza;
import com.tma.sharing.structurals.bridge.example2.implementations.VeggiePizza;


public class Client {

    /*
     * Video Reference: https://youtu.be/88kAIisOiYs
     */
    public static void main(String[] args) {
        Restaurant americanRestaurant = new AmericanRestaurant(new PepperoniPizza());
        americanRestaurant.deliver();

        System.out.println("==========================================");

        Restaurant italianRestaurant = new ItalianRestaurant(new VeggiePizza());
        italianRestaurant.deliver();
    }

}
