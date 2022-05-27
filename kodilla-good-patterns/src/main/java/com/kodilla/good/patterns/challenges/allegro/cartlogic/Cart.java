package com.kodilla.good.patterns.challenges.allegro.cartlogic;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartEntry> cartEntries = new ArrayList<>();



    public boolean addCartEntry(CartEntry cartEntry){
        if(cartEntry.getProduct().getAvailableAmount() >= cartEntry.getRequestedAmount()){
            cartEntries.add(cartEntry);
            return true;
        }
        return false;
    }

    public boolean validate() {

        long validEntries = cartEntries.stream()
                            .filter(entry -> entry.getProduct().getAvailableAmount() >= entry.getRequestedAmount() )
                            .count();

        System.out.println("Cart validation");

        return validEntries == cartEntries.size();

    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }
}
