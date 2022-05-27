package com.kodilla.good.patterns.challenges.allegro;

public class DeliveryDetails {

    private final String address;

    public DeliveryDetails(String address) {
        this.address = address;
    }

    public boolean validate() {
        System.out.println("Validating delivery details");
        return true;
    }

    public String getAddress() {
        return address;
    }
}
