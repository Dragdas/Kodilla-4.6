package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;

public class FlightSimRunner {

    public static void main(String[] args) {

        Flight f1 = new Flight("Warsaw", "Cracow");
        Flight f2 = new Flight("Berlin", "Dubai");
        Flight f3 = new Flight("Cracow", "Monaco");
        Flight f4 = new Flight("Cracow", "Dubai");
        List<Flight> flights = new ArrayList<>();
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);

        FlightFinder flightFinder = new FlightFinder(flights);

        try {
            flightFinder.findFlight(new Flight("Warsaw", "Berlin"));
        }catch (RouteNotFoundException e){
            System.out.println(e);
        }



    }


}
