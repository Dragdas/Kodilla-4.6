package com.kodilla.good.patterns.challenges.food2door.product;

public class ProductDto {

    private Product product;
    private int requestedQuantity;

    public ProductDto(Product product, int requestedQuantity) {
        this.product = product;
        this.requestedQuantity = requestedQuantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "product: " + product +
                ", requestedQuantity:" + requestedQuantity;
    }
}
