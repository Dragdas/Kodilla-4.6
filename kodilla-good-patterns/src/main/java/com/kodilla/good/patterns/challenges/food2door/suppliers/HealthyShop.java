package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.product.HealthyPancakes;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;

import java.util.List;

public class HealthyShop extends FoodSupplier{

    public HealthyShop(ServicesDto servicesDto) {
        super(servicesDto);
    }

    @Override
    public String getName() {
        return "HealthyShop";
    }

    @Override
    List<Product> getProducts() {
        return List.of(new HealthyPancakes());
    }
}
