package com.kodilla.good.patterns.challenges.allegro;

import com.kodilla.good.patterns.challenges.allegro.cartlogic.Cart;

public class Order {

    private Client client;
    private Cart cart;
    private DeliveryDetails deliveryDetails;

    public Order(Client client, Cart cart, DeliveryDetails deliveryDetails) {
        this.client = client;
        this.cart = cart;
        this.deliveryDetails = deliveryDetails;
    }

    public boolean isValid(){
        System.out.println("Validating order.");
        return client.validate() && cart.validate() && deliveryDetails.validate() ;

    }

    public Client getClient() {
        return client;
    }

    public Cart getCart() {
        return cart;
    }

    public DeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }
}
