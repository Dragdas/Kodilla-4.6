package com.kodilla.good.patterns.challenges.complettingService;

import com.kodilla.good.patterns.challenges.cartlogic.CartEntry;

import java.util.List;

public class PackagedGoodsCompletingService implements CompletingService{


    @Override
    public void displayItemsToBeIncluded(List<CartEntry> cartEntries) {
        cartEntries.forEach(cartEntry -> System.out.println(cartEntry.getProduct().getName() + " in amount of: " + cartEntry.getRequestedAmount() ));

    }
}
