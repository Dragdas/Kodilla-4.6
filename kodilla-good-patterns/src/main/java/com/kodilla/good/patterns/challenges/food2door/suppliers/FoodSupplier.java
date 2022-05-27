package com.kodilla.good.patterns.challenges.food2door.suppliers;

import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.StockDto;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.product.Ribeye;
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

    public FoodSupplier(SupplierConnectivityService supplierConnectivityService, OrderFetchingService orderFetchingService, StatusRetrieverService statusRetrieverService) {
        this.supplierConnectivityService = supplierConnectivityService;
        this.orderFetchingService = orderFetchingService;
        this.statusRetrieverService = statusRetrieverService;
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
