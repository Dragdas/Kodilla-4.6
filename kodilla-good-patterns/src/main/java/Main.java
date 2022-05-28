
import com.kodilla.good.patterns.challenges.flightsmanager.cities.City;
import com.kodilla.good.patterns.challenges.flightsmanager.cities.SupportedCities;
import com.kodilla.good.patterns.challenges.flightsmanager.flight.Flight;
import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.OrderHelper;
import com.kodilla.good.patterns.challenges.food2door.product.ExtraPopcorn;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;

import java.time.LocalDateTime;
import java.util.List;

import static com.kodilla.good.patterns.challenges.flightsmanager.cities.SupportedCities.*;


public class Main {

    public static void main(String[] args) {

        //TODO dlaczego lombok nie działa?

        Flight f1 = new Flight("FL123", City.getCity(KRK), City.getCity(WAW), List.of(City.getCity(WRO)), LocalDateTime.now(), LocalDateTime.now().plusHours(1) );

        System.out.println(f1.getArrivalTime());


    }



}
