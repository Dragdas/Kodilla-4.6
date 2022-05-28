package com.kodilla.good.patterns.challenges.food2door.product;

public class GlutenFreeJuice implements Product{
    @Override
    public String getProductName() {
        return "Gluten Free Juice";
    }

    @Override
    public int getAvailableAmount() {
        return 54;
    }

    @Override
    public String toString() {
        return "Gluten Free Juice";
    }
}
