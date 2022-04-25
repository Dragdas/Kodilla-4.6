package com.kodilla.exception.nullpointer;

public class User {

    private String userName;

    public User(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }
}
