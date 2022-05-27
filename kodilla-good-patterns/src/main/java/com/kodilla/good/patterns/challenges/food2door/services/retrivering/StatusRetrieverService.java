package com.kodilla.good.patterns.challenges.food2door.services.retrivering;

import com.kodilla.good.patterns.challenges.food2door.Order;

public interface StatusRetrieverService {

    boolean isOrderProcessed(Long id);

    Long getOrderId(Order order);

}
