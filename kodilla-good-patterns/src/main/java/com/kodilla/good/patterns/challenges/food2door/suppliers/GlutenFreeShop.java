package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.product.GlutenFreeCake;
import com.kodilla.good.patterns.challenges.food2door.product.GlutenFreeJuice;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;

import java.util.List;

public class GlutenFreeShop extends FoodSupplier{
    public GlutenFreeShop(ServicesDto servicesDto) {
        super(servicesDto);
    }

    @Override
    public String getName() {
        return "Gluten Free Shop";
    }

    @Override
    List<Product> getProducts() {

        return List.of( new GlutenFreeJuice(),
                        new GlutenFreeCake());
    }
}
