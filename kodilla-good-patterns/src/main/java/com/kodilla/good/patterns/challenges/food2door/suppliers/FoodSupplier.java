package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.StockDto;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.product.Ribeye;

import java.util.ArrayList;
import java.util.List;

public abstract class FoodSupplier implements SupplierService{

    List<Long> idsOfProcessedOrders = new ArrayList<>();

    @Override
    public StockDto getStockInformation() {
        return new StockDto(this, getProducts());
    }

    @Override
    public long process(Order order) {
        System.out.println("Connecting to " + getSupplierName());
        System.out.println("Sending order");
        System.out.println(order.toString());
        System.out.println("Retrieve process id");
        Long processID = Long.valueOf(1);
        idsOfProcessedOrders.add(processID);
        return processID;
    }

    @Override
    public boolean isOrderCompleted(Long id) {
        System.out.println("Retrieve order status");
        return true;
    }

    public String getSupplierName(){
        System.out.println("Requesting suppliers name");
        return "Suppliers name";
    }

    public List<Product> getProducts(){
        System.out.println("Request for product list");
        List<Product> products = new ArrayList<>();

        products.add( new Ribeye());

        return products;
    }

    @Override
    public String toString() {
        return "FoodSupplier: " + getSupplierName();
    }
}
