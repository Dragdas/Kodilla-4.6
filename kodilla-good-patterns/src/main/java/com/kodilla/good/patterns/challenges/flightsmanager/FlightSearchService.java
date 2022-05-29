package com.kodilla.good.patterns.challenges.flightsmanager;

import com.kodilla.good.patterns.challenges.flightsmanager.cities.City;
import com.kodilla.good.patterns.challenges.flightsmanager.flight.Flight;
import com.kodilla.good.patterns.challenges.flightsmanager.flightsDB.FlightsDBEmulator;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {

    private FlightsDBEmulator flightsDB;

    public FlightSearchService(FlightsDBEmulator flightsDB) {
        this.flightsDB = flightsDB;
    }

    public List<Flight> findFlightsFrom(City departure){
        return flightsDB.getFlights().stream()
                .filter(flight -> flight.getDeparture().equals(departure))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsTo(City destination){
        return flightsDB.getFlights().stream()
                .filter(flight -> flight.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsWithStopoverIn(City stopover){
        return flightsDB.getFlights().stream()
                .filter(flight -> flight.getStopovers().contains(stopover) )
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsWithStopoversIn(List<City> stopovers){
        return flightsDB.getFlights().stream()
                .filter(flight -> new HashSet<>(new HashSet<>(flight.getStopovers())).containsAll(stopovers) )
                .collect(Collectors.toList());
    }



}
