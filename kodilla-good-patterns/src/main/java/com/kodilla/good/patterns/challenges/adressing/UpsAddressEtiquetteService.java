package com.kodilla.good.patterns.challenges.adressing;

import com.kodilla.good.patterns.challenges.DeliveryDetails;

public class UpsAddressEtiquetteService implements AddressingService{

    @Override
    public void prepareAddressEtiquette(DeliveryDetails deliveryDetails) {
        System.out.println("Address package to " + deliveryDetails.getAdress());
    }
}
