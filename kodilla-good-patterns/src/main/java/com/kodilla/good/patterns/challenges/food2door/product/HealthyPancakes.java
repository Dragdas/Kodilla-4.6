package com.kodilla.good.patterns.challenges.food2door.product;

public class HealthyPancakes implements Product{
    @Override
    public String getProductName() {
        return "Healthy Pancakes";
    }

    @Override
    public int getAvailableAmount() {
        return 66;
    }

    @Override
    public String toString() {
        return "Healthy Pancakes";
    }
}
