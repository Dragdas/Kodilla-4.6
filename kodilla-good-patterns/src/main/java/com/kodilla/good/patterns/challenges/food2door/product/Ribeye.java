package com.kodilla.good.patterns.challenges.food2door.product;



public class Ribeye implements Product{

    private String name = "Ribeye steak";

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public int getAvailableAmount() {
        return 256;
    }

    @Override
    public String toString() {
        return name + " (available:" + getAvailableAmount() +  ") ";
    }
}
