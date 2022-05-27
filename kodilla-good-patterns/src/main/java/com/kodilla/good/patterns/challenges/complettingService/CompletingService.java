package com.kodilla.good.patterns.challenges.complettingService;

import com.kodilla.good.patterns.challenges.cartlogic.CartEntry;

import java.util.List;

public interface CompletingService {

    void displayItemsToBeIncluded(List<CartEntry> cartEntries);

}
