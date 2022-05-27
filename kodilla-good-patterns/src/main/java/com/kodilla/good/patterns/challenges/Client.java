package com.kodilla.good.patterns.challenges;

public class Client {

    private final String userName;

    public Client(String userName) {
        this.userName = userName;
    }

    public boolean validate() {
        System.out.println("User validation");
        return true;
    }

    public String getUserName() {
        return userName;
    }
}
