package com.kodilla.good.patterns.challenges.allegro;

import com.kodilla.good.patterns.challenges.allegro.adressing.AddressingService;
import com.kodilla.good.patterns.challenges.allegro.adressing.UpsAddressEtiquetteService;
import com.kodilla.good.patterns.challenges.allegro.complettingService.CompletingService;
import com.kodilla.good.patterns.challenges.allegro.complettingService.PackagedGoodsCompletingService;
import com.kodilla.good.patterns.challenges.allegro.packaging.PackagingService;
import com.kodilla.good.patterns.challenges.allegro.packaging.PackingBoxService;

public  class AllegroSolutionRunner {

    public static void runSolution(){

        PackagingService packagingService = new PackingBoxService();
        AddressingService addressingService = new UpsAddressEtiquetteService();
        CompletingService completingService = new PackagedGoodsCompletingService();


        ProductOrderService productOrderService = new ProductOrderService(packagingService, addressingService, completingService);
        Order order = OrderGenerator.generateOrder();
        productOrderService.executeOrder(order);
    }
}
