package com.kodilla.good.patterns.challenges.flightsmanager.cities;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;

import static com.kodilla.good.patterns.challenges.flightsmanager.cities.SupportedCities.*;


public class City {

    @Getter private String name;
    @Getter private String alias;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getName(), city.getName()) && Objects.equals(getAlias(), city.getAlias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAlias());
    }

    @Override
    public String toString() {
        return name;
    }
}
