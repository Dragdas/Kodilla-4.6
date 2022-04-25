package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightFinder {

    private List<Flight> flightList = new ArrayList<>();

    public FlightFinder(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public void findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> flightMap = new HashMap<>();
        flightList.stream()
                .map(Flight::getArrivalAirport)
                .forEach(f -> flightMap.put(f,true));

        if ( !flightMap.containsKey(flight.getArrivalAirport()) )
            throw new RouteNotFoundException("Nie znaleziono lotu do :" + flight.getArrivalAirport());

        List<String> possibleAirports = flightList.stream()
                .filter(f -> f.getArrivalAirport().equals(flight.getArrivalAirport()))
                .map(Flight::getDepartureAirport)
                .toList();

        System.out.println("Możesz polecieć do " + flight.getArrivalAirport() + " z " + possibleAirports);
    }


}
