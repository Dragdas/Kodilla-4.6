package com.kodilla.good.patterns.challenges.allegro.complettingService;

import com.kodilla.good.patterns.challenges.allegro.cartlogic.CartEntry;

import java.util.List;

public class PackagedGoodsCompletingService implements CompletingService{


    @Override
    public void displayItemsToBeIncluded(List<CartEntry> cartEntries) {
        cartEntries.forEach(cartEntry -> System.out.println(cartEntry.getProduct().getName() + " in amount of: " + cartEntry.getRequestedAmount() ));

    }
}
