package com.kodilla.testing.weather.stub;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String,Double> calculateForecast(){
        Map<String,Double> result = new HashMap<>();

        temperatures.getTemperatures()
                .forEach((s, aDouble) -> result.put(s,aDouble+1));

        return result;
    }

    public double calculateMean(){
        return temperatures.getTemperatures()
                                        .values()
                                        .stream()
                                        .mapToDouble(value -> value)
                                        .average().getAsDouble();

    }

    public double calculateMedian(){
        List<Double> sortedValues = temperatures.getTemperatures()
                .values()
                .stream()
                .sorted()
                .toList();

        if(sortedValues.size() % 2 == 0){
            return (sortedValues.get(sortedValues.size()/2) + sortedValues.get(sortedValues.size()/2-1))/2;
        }
        else{
            return sortedValues.get(sortedValues.size()/2);
        }

    }


}
