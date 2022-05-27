package com.kodilla.good.patterns.challenges.allegro;

import com.kodilla.good.patterns.challenges.allegro.adressing.AddressingService;
import com.kodilla.good.patterns.challenges.allegro.adressing.UpsAddressEtiquetteService;
import com.kodilla.good.patterns.challenges.allegro.complettingService.CompletingService;
import com.kodilla.good.patterns.challenges.allegro.complettingService.PackagedGoodsCompletingService;
import com.kodilla.good.patterns.challenges.allegro.packaging.PackagingService;
import com.kodilla.good.patterns.challenges.allegro.packaging.PackingBoxService;

public class ProductOrderService {

    PackagingService packagingService;
    AddressingService addressingService;
    CompletingService completingService;

    public ProductOrderService(PackagingService packagingService, AddressingService addressingService, CompletingService completingService) {
        this.packagingService = packagingService;
        this.addressingService = addressingService;
        this.completingService = completingService;
    }

    public boolean executeOrder(Order order){

        if( !order.isValid() )
            return false;



        packagingService.prepareContainer(order.getClient());
        addressingService.prepareAddressEtiquette(order.getDeliveryDetails());
        completingService.displayItemsToBeIncluded(order.getCart().getCartEntries());

        return true;
    }



}
