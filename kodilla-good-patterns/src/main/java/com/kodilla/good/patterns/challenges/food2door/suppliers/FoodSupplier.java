package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.StockDto;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.product.Ribeye;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;
import com.kodilla.good.patterns.challenges.food2door.services.connectivity.SupplierConnectivityService;
import com.kodilla.good.patterns.challenges.food2door.services.feching.OrderFetchingService;
import com.kodilla.good.patterns.challenges.food2door.services.retrivering.StatusRetrieverService;

import java.util.ArrayList;
import java.util.List;

public abstract class FoodSupplier implements Supplier {


    List<Long> idsOfProcessedOrders = new ArrayList<>();

    SupplierConnectivityService supplierConnectivityService;
    OrderFetchingService orderFetchingService;
    StatusRetrieverService statusRetrieverService;

    public FoodSupplier(ServicesDto servicesDto) {
        this.supplierConnectivityService = servicesDto.getConnectivityService();
        this.orderFetchingService = servicesDto.getOrderFetchingService();
        this.statusRetrieverService = servicesDto.getStatusRetrieverService();
    }


    @Override
    public StockDto getStockInformation() {
        return new StockDto(this, getProducts());
    }

    @Override
    public long process(Order order) {
        supplierConnectivityService.connectTo(this);

        orderFetchingService.fetchOrder(order);

        Long processID = statusRetrieverService.getOrderId(order);
        idsOfProcessedOrders.add(processID);
        return processID;
    }

    @Override
    public boolean isOrderCompleted(Long id) {
        return statusRetrieverService.isOrderProcessed(id);
    }

    public abstract String getName();

    abstract List<Product> getProducts();

    @Override
    public String toString() {
        return "FoodSupplier: " + getName();
    }
}
