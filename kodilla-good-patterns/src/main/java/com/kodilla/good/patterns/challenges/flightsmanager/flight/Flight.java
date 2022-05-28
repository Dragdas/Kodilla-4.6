package com.kodilla.good.patterns.challenges.flightsmanager.flight;

import com.kodilla.good.patterns.challenges.flightsmanager.cities.City;

import java.time.LocalDateTime;
import java.util.List;


public class Flight {

    private String id;
    private City departure;
    private City destination;
    private List<City> stopovers;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Flight(String id, City departure, City destination, List<City> stopovers, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.stopovers = stopovers;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getId() {
        return id;
    }

    public City getDeparture() {
        return departure;
    }

    public City getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public List<City> getStopovers() {
        return stopovers;
    }
}
