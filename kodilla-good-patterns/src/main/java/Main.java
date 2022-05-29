
import com.kodilla.good.patterns.challenges.flightsmanager.FlightSearchService;
import com.kodilla.good.patterns.challenges.flightsmanager.cities.City;
import com.kodilla.good.patterns.challenges.flightsmanager.flight.Flight;
import com.kodilla.good.patterns.challenges.flightsmanager.flightsDB.FlightsDBEmulator;

import java.util.List;

import static com.kodilla.good.patterns.challenges.flightsmanager.cities.SupportedCities.*;


public class Main {

    public static void main(String[] args) {

        FlightsDBEmulator   flightsDBEmulator =     new FlightsDBEmulator();
        FlightSearchService flightSearchService =   new FlightSearchService(flightsDBEmulator);

        List<Flight> flightsToWro = flightSearchService.findFlightsTo(City.getCity(WRO));
        List<Flight> flightsFromGDK = flightSearchService.findFlightsFrom(City.getCity(GDK));
        List<Flight> flightsFromGDKtoWRO = flightSearchService.findFlight(City.getCity(GDK), City.getCity(WRO), true);
        List<Flight> flightsDirectlyFromGDKtoWRO = flightSearchService.findFlight(City.getCity(GDK), City.getCity(WRO), false);

        System.out.println();
        flightsToWro.forEach(System.out::println);
        System.out.println();

        System.out.println();
        flightsFromGDK.forEach(System.out::println);
        System.out.println();

        System.out.println();
        flightsFromGDK.forEach(System.out::println);
        System.out.println();

        System.out.println();
        flightsFromGDKtoWRO.forEach(System.out::println);
        System.out.println();

        System.out.println();
        flightsDirectlyFromGDKtoWRO.forEach(System.out::println);
        System.out.println();


    }

}
