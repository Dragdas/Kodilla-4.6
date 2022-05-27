package com.kodilla.good.patterns.challenges.products;

public class Game implements Product{

    private final String name;

    public Game(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAvailableAmount() {
        System.out.println("Check stock of " + name);
        return 6;
    }
}
