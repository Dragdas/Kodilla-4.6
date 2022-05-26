package com.kodilla.good.patterns.challenges.cartlogic;

import com.kodilla.good.patterns.challenges.products.Product;

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
