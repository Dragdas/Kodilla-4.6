package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.product.ProductDto;
import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;

import java.util.List;

public class Order {

    private final FoodSupplier foodSupplier;
    private final List<ProductDto> products;


    public Order(FoodSupplier foodSupplier, List<ProductDto> products) {
        this.foodSupplier = foodSupplier;
        this.products = products;
    }

    public FoodSupplier getFoodSupplier() {
        return foodSupplier;
    }

    @Override
    public String toString() {
        return "Order{" +
                "foodSupplier=" + foodSupplier +
                ", products=" + products +
                '}';
    }
}
