package com.kodilla.good.patterns.challenges.food2door.product;

public class NewYorkStrip implements Product{

    private String name = "New York Strip";

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public int getAvailableAmount() {
        return 40;
    }

    @Override
    public String toString() {
        return name + " (available:" + getAvailableAmount() +  ") ";
    }
}
