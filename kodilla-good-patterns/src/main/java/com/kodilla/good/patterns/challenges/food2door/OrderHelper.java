package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.product.*;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;
import com.kodilla.good.patterns.challenges.food2door.services.connectivity.BasicConnectivityService;
import com.kodilla.good.patterns.challenges.food2door.services.feching.BasicOrderFetchingService;
import com.kodilla.good.patterns.challenges.food2door.services.retrivering.BasicStatusRetriever;
import com.kodilla.good.patterns.challenges.food2door.suppliers.*;

import java.util.List;

public class OrderHelper {

    private OrderHelper() {
    }

    public static void executeOrderingProcess(Order order){
        System.out.println("\n");

        FoodSupplier supplier = order.getFoodSupplier();

        System.out.println( supplier.getStockInformation() );
        long orderId = supplier.process( order);
        System.out.println("Is order completed: " + supplier.isOrderCompleted(orderId));

        System.out.println("\n");
    }

    public static ServicesDto generateServicesDto(){
        return new ServicesDto(new BasicConnectivityService(), new BasicOrderFetchingService(), new BasicStatusRetriever());
    }

    public static Order generateSteakOrder(){

        return new Order(new SteakSupplier(generateServicesDto()),
                List.of(
                new ProductDto(new Ribeye(), 5),
                new ProductDto(new NewYorkStrip(), 2)));
    }

    public static Order generateExtraFoodOrder(){
        return new Order(new ExtraFoodShop(generateServicesDto()),
                List.of(
                        new ProductDto(new ExtraPopcorn(), 10)));
    }

    public static Order generateHealthyShopOrder(){
        return new Order(new HealthyShop(generateServicesDto()),
                List.of(
                        new ProductDto(new HealthyPancakes(), 10)));
    }

    public static Order generateGlutenFreeOrder(){

        return new Order(new GlutenFreeShop(generateServicesDto()),
                List.of(
                        new ProductDto(new GlutenFreeCake(), 10),
                        new ProductDto(new GlutenFreeJuice(),5)));
    }

}
