package com.kodilla.good.patterns.challenges.food2door.services.feching;

import com.kodilla.good.patterns.challenges.food2door.Order;

public class BasicOrderFetchingService implements OrderFetchingService{
    @Override
    public void fetchOrder(Order order) {
        System.out.println("Sending order");
        System.out.println(order.toString());
    }
}
