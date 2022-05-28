package com.kodilla.good.patterns.challenges.flightsmanager.cities;

import java.util.Map;

public class City {

    private String name;
    private String alias;

    private City(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    private static Map<String, City> cities = Map.of(
            "GDK", new City("Gdansk", "GDK"),
            "WRO", new City("Wroclaw", "WRO")
    );

    public static City getCity(String cityAlias){
        return cities.get(cityAlias);
    }

}
