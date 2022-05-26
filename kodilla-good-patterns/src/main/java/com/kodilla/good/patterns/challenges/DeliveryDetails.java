package com.kodilla.good.patterns.challenges;

public class DeliveryDetails {

    private String adress;

    public DeliveryDetails(String adress) {
        this.adress = adress;
    }

    public boolean validate() {
        System.out.println("Validating delivery details");
        return true;
    }

    public String getAdress() {
        return adress;
    }
}
