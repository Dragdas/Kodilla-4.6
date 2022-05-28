package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.product.ExtraPopcorn;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;
import com.kodilla.good.patterns.challenges.food2door.services.connectivity.SupplierConnectivityService;
import com.kodilla.good.patterns.challenges.food2door.services.feching.OrderFetchingService;
import com.kodilla.good.patterns.challenges.food2door.services.retrivering.StatusRetrieverService;

import java.util.List;

public class ExtraFoodShop extends FoodSupplier{

    private final String name = "Extra foods";

    public ExtraFoodShop(ServicesDto servicesDto) {
        super(servicesDto);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    List<Product> getProducts() {
        return List.of(new ExtraPopcorn());
    }
}
