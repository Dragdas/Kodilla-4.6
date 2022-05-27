package com.kodilla.good.patterns.challenges.allegro;

import com.kodilla.good.patterns.challenges.allegro.cartlogic.Cart;
import com.kodilla.good.patterns.challenges.allegro.cartlogic.CartEntry;
import com.kodilla.good.patterns.challenges.allegro.products.Game;
import com.kodilla.good.patterns.challenges.allegro.products.Kapcie;

public class OrderGenerator {

    //tylko na potrzeby zaprezentowania że wszytsko działa

    public static Order generateOrder() {

        Client client = new Client("Obi One");
        Cart cart = new Cart();
        cart.addCartEntry(new CartEntry(new Game("SW: KoTOR"), 1  ));
        cart.addCartEntry(new CartEntry(new Kapcie("Kapcie babuszki"), 2  ));

        DeliveryDetails deliveryDetails = new DeliveryDetails("Tatooine");

        return new Order(client, cart, deliveryDetails);
    }
}
