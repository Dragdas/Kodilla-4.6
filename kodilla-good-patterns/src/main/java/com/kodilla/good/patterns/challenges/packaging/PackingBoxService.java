package com.kodilla.good.patterns.challenges.packaging;

import com.kodilla.good.patterns.challenges.Client;

public class PackingBoxService implements PackagingService{

    @Override
    public void prepareContainer(Client client) {
        System.out.println("Prepare box for delivery. Client: " + client.getUserName() );
    }
}
