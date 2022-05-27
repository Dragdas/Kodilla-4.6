package com.kodilla.good.patterns.challenges.allegro.adressing;

import com.kodilla.good.patterns.challenges.allegro.DeliveryDetails;

public class UpsAddressEtiquetteService implements AddressingService{

    @Override
    public void prepareAddressEtiquette(DeliveryDetails deliveryDetails) {
        System.out.println("Address package to " + deliveryDetails.getAddress());
    }
}
