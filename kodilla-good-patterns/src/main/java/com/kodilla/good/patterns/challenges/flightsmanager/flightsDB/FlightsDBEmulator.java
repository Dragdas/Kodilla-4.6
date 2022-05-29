package com.kodilla.good.patterns.challenges.flightsmanager.flightsDB;

import com.kodilla.good.patterns.challenges.flightsmanager.cities.City;
import com.kodilla.good.patterns.challenges.flightsmanager.flight.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.kodilla.good.patterns.challenges.flightsmanager.cities.SupportedCities.*;

public class FlightsDBEmulator {

    private List<Flight> flights = new ArrayList<>();

    public FlightsDBEmulator() {
        generateInitialFlights();
    }

    private void generateInitialFlights(){

        List<City> stopovers1 = new ArrayList<>();
        stopovers1.add(City.getCity(KRK));
        stopovers1.add(City.getCity(WAW));

        List<City> stopovers2 = new ArrayList<>();
        stopovers2.add(City.getCity(WAW));

        flights.add(new Flight( "FL0001", City.getCity(GDK), City.getCity(WRO), LocalDateTime.now().plusHours(0), LocalDateTime.now().plusHours(2)  ));
        flights.add(new Flight( "FL0002", City.getCity(GDK), City.getCity(WRO), stopovers2, LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5)  ));
        flights.add(new Flight( "FL0003", City.getCity(GDK), City.getCity(WRO), stopovers1, LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(6)  ));
        flights.add(new Flight( "FL0004", City.getCity(GDK), City.getCity(WRO), stopovers2, LocalDateTime.now().plusHours(8), LocalDateTime.now().plusHours(10)  ));
        flights.add(new Flight( "FL0005", City.getCity(GDK), City.getCity(WRO), LocalDateTime.now().plusHours(10), LocalDateTime.now().plusHours(12)  ));
        flights.add(new Flight( "FL0006", City.getCity(GDK), City.getCity(WRO), stopovers1, LocalDateTime.now().plusHours(13), LocalDateTime.now().plusHours(15)  ));
        flights.add(new Flight( "FL0007", City.getCity(GDK), City.getCity(WRO), stopovers2, LocalDateTime.now().plusHours(18), LocalDateTime.now().plusHours(20)  ));

    }

    public List<Flight> getFlights() {
        return flights;
    }
}
