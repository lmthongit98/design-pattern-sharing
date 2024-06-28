package com.tma.sharing.structurals.composite.problem;

import java.util.ArrayList;
import java.util.List;


public class CompositeProblem {

    static class Item {
        private String name;
        private float price;
        private List<Item> children;

        public Item(String name, float price) {
            this.name = name;
            this.price = price;
            this.children = new ArrayList<>();
        }

        public float getCost() {
            float cost = this.price;
            for (Item child : children) {
                cost += child.getCost();
            }
            return cost;
        }
    }

    public static Item createPackage() {
        // It's a box, not an item
        Item rootBox = new Item(
                "root box",
                // so it have no price
                0);

        // // but it has children
        rootBox.children.add(new Item("Mouse", 20.5f));

        // 	Another box contains items
        Item subBox = new Item("sub box", 0);
        subBox.children.add(new Item("Keyboard", 60));
        subBox.children.add(new Item("Charger", 15));

        rootBox.children.add(subBox);

        return rootBox;
    }

    public static void main(String[] args) {
        Item myPackage = createPackage();
        System.out.println(myPackage.getCost());
    }

}
