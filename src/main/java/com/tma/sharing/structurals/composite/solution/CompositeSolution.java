package com.tma.sharing.structurals.composite.solution;

import java.util.ArrayList;
import java.util.List;

public class CompositeSolution {

    // Component interface
    public interface PackageComponent {
        float getCost();
    }


    // Leaf class
    public static class Item implements PackageComponent {
        private String name;
        private float price;

        public Item(String name, float price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public float getCost() {
            return price;
        }
    }

    // Composite class
    public static class Box implements PackageComponent {
        private String name;
        private List<PackageComponent> children;

        public Box(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public void addChild(PackageComponent component) {
            children.add(component);
        }

        @Override
        public float getCost() {
            float totalCost = 0;
            for (PackageComponent component : children) {
                totalCost += component.getCost();
            }
            return totalCost;
        }
    }

    public static PackageComponent createPackage() {
        Box rootBox = new Box("root box");

        // Adding items to root box
        rootBox.addChild(new Item("Mouse", 20.5f));

        // Adding sub box to root box
        Box subBox = new Box("sub box");
        subBox.addChild(new Item("Keyboard", 60));
        subBox.addChild(new Item("Charger", 15));

        rootBox.addChild(subBox);

        return rootBox;
    }

    public static void main(String[] args) {
        PackageComponent myPackage = createPackage();
        System.out.println("Total cost: " + myPackage.getCost());
    }

}
