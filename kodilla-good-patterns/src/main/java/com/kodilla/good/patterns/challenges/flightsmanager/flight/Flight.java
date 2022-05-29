package com.kodilla.good.patterns.challenges.flightsmanager.flight;

import com.kodilla.good.patterns.challenges.flightsmanager.cities.City;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Flight {

    private String id;
    private City departure;
    private City destination;
    private List<City> stopovers = new ArrayList<>();
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

    public Flight(String id, City departure, City destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
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

    @Override
    public String toString() {
        return "Flight id: " + id +
                ", departure from: " + departure +
                ", to: "  + destination +
                ", with stopovers: " + stopovers +
                ", departureTime: " + departureTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) +
                ", arrivalTime=" + arrivalTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
