package com.kodilla.good.patterns.challenges.food2door.product;

public class ExtraPopcorn implements Product{

    @Override
    public String getProductName() {
        return "Popcorn";
    }

    @Override
    public int getAvailableAmount() {
        return 500;
    }

    @Override
    public String toString() {
        return "ExtraPopcorn";
    }
}
