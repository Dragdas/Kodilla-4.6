package com.kodilla.good.patterns.challenges.allegro.cartlogic;

import com.kodilla.good.patterns.challenges.allegro.products.Product;

public class CartEntry {

    private final Product product;
    private final int requestedAmount;

    public CartEntry(Product product, int requestedAmount) {
        this.product = product;
        this.requestedAmount = requestedAmount;
    }

    public Product getProduct() {
        return product;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }
}
