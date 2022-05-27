package com.kodilla.good.patterns.challenges.allegro;

import com.kodilla.good.patterns.challenges.allegro.adressing.AddressingService;
import com.kodilla.good.patterns.challenges.allegro.adressing.UpsAddressEtiquetteService;
import com.kodilla.good.patterns.challenges.allegro.complettingService.CompletingService;
import com.kodilla.good.patterns.challenges.allegro.complettingService.PackagedGoodsCompletingService;
import com.kodilla.good.patterns.challenges.allegro.packaging.PackagingService;
import com.kodilla.good.patterns.challenges.allegro.packaging.PackingBoxService;

public class ProductOrderService {


    public boolean executeOrder(Order order){

        if( !order.isValid() )
            return false;

        PackagingService packagingService = new PackingBoxService();
        AddressingService addressingService = new UpsAddressEtiquetteService();
        CompletingService completingService = new PackagedGoodsCompletingService();

        packagingService.prepareContainer(order.getClient());
        addressingService.prepareAddressEtiquette(order.getDeliveryDetails());
        completingService.displayItemsToBeIncluded(order.getCart().getCartEntries());

        return true;
    }



}
