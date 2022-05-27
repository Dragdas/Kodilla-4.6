package com.kodilla.good.patterns.challenges.allegro;

public  class AllegroSolutionRunner {

    public static void runSolution(){
        ProductOrderService productOrderService = new ProductOrderService();
        Order order = OrderGenerator.generateOrder();
        productOrderService.executeOrder(order);
    }
}
