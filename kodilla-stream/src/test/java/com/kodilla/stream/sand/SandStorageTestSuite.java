package com.kodilla.stream.sand;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SandStorageTestSuite {

    @Test
    void testGetSandBeansQuantity(){
        //Given
        List<SandStorage> continents = List.of(new Asia(),new Africa(), new Europe());

        //When
        BigDecimal totalSand = BigDecimal.ZERO;
        for( SandStorage con : continents){
            totalSand =  totalSand.add(con.getSandBeansQuantity());
        }

        //then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        assertEquals(expectedSand, totalSand);

    }

    @Test
    void testGetSandBeansQuantityWithReduce(){
        //Given
        List<SandStorage> continents = List.of(new Asia(),new Africa(), new Europe());

        //When
        BigDecimal totalSand = continents.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        assertEquals(expectedSand, totalSand);
    }


}
