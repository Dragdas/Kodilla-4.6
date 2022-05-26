package com.kodilla.good.patterns.challenges;

public class ProductOrderService {


    public boolean executeOrder(Order order){

        if( !order.isOrderValid() )
            return false;

        System.out.println("Prepare delivery for: " + order.getClient().getUserName() );
        System.out.println("Address package: " + order.getDeliveryDetails().getAdress());
        System.out.println("Include:");
        order.getCart().getCartEntries()
                .forEach(cartEntry -> System.out.println(cartEntry.getProduct().getName() + " in amount of: " + cartEntry.getRequestedAmount() ));

        return true;
    }



}
