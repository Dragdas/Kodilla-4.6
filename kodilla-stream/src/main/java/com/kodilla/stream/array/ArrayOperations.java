package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
                .forEach(n -> System.out.println(numbers[n]));

        return numbers.length == 0 ? 0 : (double) IntStream.range(0, numbers.length)
                                                                    .map(n -> numbers[n])
                                                                    .sum() / numbers.length;
    }

}
