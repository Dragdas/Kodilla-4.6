package com.kodilla.good.patterns.challenges.allegro.packaging;

import com.kodilla.good.patterns.challenges.allegro.Client;

public class PackingBoxService implements PackagingService{

    @Override
    public void prepareContainer(Client client) {
        System.out.println("Prepare box for delivery. Client: " + client.getUserName() );
    }
}
