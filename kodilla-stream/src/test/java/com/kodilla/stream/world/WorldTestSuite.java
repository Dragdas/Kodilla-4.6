package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        //Europe
        Country poland  = new Country(new BigDecimal("36000000000"));
        Country france  = new Country(new BigDecimal("67000000000"));
        Country uk      = new Country(new BigDecimal("67000000000"));
        Country spain   = new Country(new BigDecimal("47000000000"));

        //Asia
        Country china       = new Country(new BigDecimal("1400000000000"));
        Country tailand     = new Country(new BigDecimal("70000000000"));
        Country sriLanka    = new Country(new BigDecimal("22000000000"));
        Country hongKong    = new Country(new BigDecimal("800000000"));

        //Africa
        Country egypt = new Country(new BigDecimal("102000000000"));
        Country congo = new Country(new BigDecimal("89000000000"));
        Country kenya = new Country(new BigDecimal("53000000000"));

        Continent europe    = new Continent(List.of(poland,france,uk,spain));
        Continent asia      = new Continent(List.of(china, tailand, sriLanka, hongKong));
        Continent africa    = new Continent(List.of(egypt, congo, kenya));

        World world = new World(List.of(europe, asia, africa));

        //when
        BigDecimal result = world.getPeopleQuantity();
        BigDecimal expectedResult = new BigDecimal("1953800000000");

        //Then
        assertEquals(expectedResult,result);

    }


}
