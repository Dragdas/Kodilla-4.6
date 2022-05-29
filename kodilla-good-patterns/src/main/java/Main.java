
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
        List<Flight> flightsWithStopover= flightSearchService.findFlightsWithStopoverIn(City.getCity(WAW));
        List<Flight> flightsWithStopovers = flightSearchService.findFlightsWithStopoversIn(List.of(City.getCity(WAW), City.getCity(KRK) ));

        System.out.println();
        flightsToWro.forEach(System.out::println);
        System.out.println();

        System.out.println();
        flightsFromGDK.forEach(System.out::println);
        System.out.println();

        System.out.println();
        flightsWithStopover.forEach(System.out::println);
        System.out.println();

        System.out.println();
        flightsWithStopovers.forEach(System.out::println);
        System.out.println();

    }

}
