package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.StockDto;

public interface Supplier {

    StockDto getStockInformation();

    long process(Order Order);

    boolean isOrderCompleted(Long id);

}
