package com.kodilla.good.patterns.challenges.food2door.product;

public class GlutenFreeCake implements Product{
    @Override
    public String getProductName() {
        return "Gluten Free Cake";
    }

    @Override
    public int getAvailableAmount() {
        return 12;
    }

    @Override
    public String toString() {
        return "Gluten Free Cake";
    }
}
