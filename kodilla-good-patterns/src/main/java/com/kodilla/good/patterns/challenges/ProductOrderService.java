package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.adressing.AddressingService;
import com.kodilla.good.patterns.challenges.adressing.UpsAddressEtiquetteService;
import com.kodilla.good.patterns.challenges.complettingService.CompletingService;
import com.kodilla.good.patterns.challenges.complettingService.PackagedGoodsCompletingService;
import com.kodilla.good.patterns.challenges.packaging.PackagingService;
import com.kodilla.good.patterns.challenges.packaging.PackingBoxService;

public class ProductOrderService {


    public boolean executeOrder(Order order){

        if( !order.isOrderValid() )
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
