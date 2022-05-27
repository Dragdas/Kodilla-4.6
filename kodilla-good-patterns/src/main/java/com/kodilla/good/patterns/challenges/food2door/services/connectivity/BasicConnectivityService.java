package com.kodilla.good.patterns.challenges.food2door.services.connectivity;

import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;

public class BasicConnectivityService implements SupplierConnectivityService{

    @Override
    public void connectTo(FoodSupplier foodSupplier) {
        System.out.println("Connecting to " + foodSupplier.getSupplierName());
    }
}
