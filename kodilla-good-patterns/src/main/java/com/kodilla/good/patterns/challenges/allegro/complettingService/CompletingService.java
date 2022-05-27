package com.kodilla.good.patterns.challenges.allegro.complettingService;

import com.kodilla.good.patterns.challenges.allegro.cartlogic.CartEntry;

import java.util.List;

public interface CompletingService {

    void displayItemsToBeIncluded(List<CartEntry> cartEntries);

}
