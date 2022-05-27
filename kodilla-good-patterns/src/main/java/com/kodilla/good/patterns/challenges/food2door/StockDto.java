package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;

import java.util.List;

public class StockDto {

    private FoodSupplier supplier;
    private List<Product> products;

    public StockDto(FoodSupplier supplier, List<Product> products) {
        this.supplier = supplier;
        this.products = products;
    }

    @Override
    public String toString() {
        return  "supplier: " + supplier +
                ", products: " + products;
    }
}
