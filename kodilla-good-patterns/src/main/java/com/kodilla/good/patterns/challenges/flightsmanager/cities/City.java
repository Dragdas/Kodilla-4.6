package com.kodilla.good.patterns.challenges.flightsmanager.cities;


import java.util.Map;

import static com.kodilla.good.patterns.challenges.flightsmanager.cities.SupportedCities.*;

public class City {

    private String name;
    private String alias;

    private City(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    private static Map<SupportedCities, City> cities = Map.of(
            GDK, new City("Gdansk", "GDK"),
            WRO, new City("Wroclaw", "WRO"),
            KRK, new City("Krakow", "KRK"),
            WAW, new City("Warszawa", "WAW")
    );

    public static City getCity(SupportedCities cityAlias){
        return cities.get(cityAlias);
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }
}
