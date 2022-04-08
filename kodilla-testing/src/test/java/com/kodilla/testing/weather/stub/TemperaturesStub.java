package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures{


    @Override
    public Map<String, Double> getTemperatures() {
        return Map.of
                                                (
                                                "Rzeszow", 25.5,
                                                "Krakow", 26.2,
                                                "Wroclaw", 24.8,
                                                "Warszawa", 25.2,
                                                "Gdansk", 26.1
                                                );

    }
}
