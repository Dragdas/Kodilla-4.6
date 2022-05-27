package com.kodilla.good.patterns.challenges.food2door.services.retrivering;

import com.kodilla.good.patterns.challenges.food2door.Order;

public class BasicStatusRetriever implements StatusRetrieverService{
    @Override
    public boolean isOrderProcessed(Long id) {
        System.out.println("Requesting for order status.");
        return true;
    }

    @Override
    public Long getOrderId(Order order) {
        System.out.println("Requesting order ID");
        return Long.valueOf(1);
    }
}
