package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.product.NewYorkStrip;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.product.Ribeye;

import java.util.ArrayList;
import java.util.List;

public class SteakSupplier extends FoodSupplier{

    private final String name = "Best steaks";

    @Override
    public List<Product> getProducts(){
        System.out.println("Request for product list");
        List<Product> products = new ArrayList<>();

        products.add( new Ribeye());
        products.add(new NewYorkStrip());

        return products;
    }

    @Override
    public String getSupplierName(){
        return name;
    }

}
