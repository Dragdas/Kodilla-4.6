package com.kodilla.good.patterns.challenges.flightsmanager.flight;

import com.kodilla.good.patterns.challenges.flightsmanager.cities.City;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Flight {

    private String id;
    private City departure;
    private City destination;
    private List<City> stopovers = new ArrayList<>();
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Flight(String id, City departure, City destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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
