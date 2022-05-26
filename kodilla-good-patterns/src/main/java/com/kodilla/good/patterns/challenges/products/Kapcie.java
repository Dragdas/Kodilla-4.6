package com.kodilla.good.patterns.challenges.products;

public class Kapcie implements Product{

    private String name;

    public Kapcie(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAvailableAmount() {
        System.out.println("Check stock of " + name);
        return 15;
    }
}
