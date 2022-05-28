package com.kodilla.good.patterns.challenges.food2door.services;

import com.kodilla.good.patterns.challenges.food2door.services.connectivity.SupplierConnectivityService;
import com.kodilla.good.patterns.challenges.food2door.services.feching.OrderFetchingService;
import com.kodilla.good.patterns.challenges.food2door.services.retrivering.StatusRetrieverService;

public class ServicesDto {

    private SupplierConnectivityService connectivityService;
    private OrderFetchingService orderFetchingService;
    private StatusRetrieverService statusRetrieverService;

    public ServicesDto(SupplierConnectivityService connectivityService, OrderFetchingService orderFetchingService, StatusRetrieverService statusRetrieverService) {
        this.connectivityService = connectivityService;
        this.orderFetchingService = orderFetchingService;
        this.statusRetrieverService = statusRetrieverService;
    }

    public SupplierConnectivityService getConnectivityService() {
        return connectivityService;
    }

    public OrderFetchingService getOrderFetchingService() {
        return orderFetchingService;
    }

    public StatusRetrieverService getStatusRetrieverService() {
        return statusRetrieverService;
    }
}
