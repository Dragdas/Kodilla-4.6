package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigmacTestSuite {


    @Test
    void testBigMacBuilder(){

        //When
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("With sezame")
                .burgers(2)
                .sauce("normal")
                .ingredients("bacon")
                .ingredients("chease")
                .build();

        System.out.println(bigmac);

        int burgersAmount = bigmac.getBurgers();
        int ingredientsAmount = bigmac.getIngredients().size();
        String bun = bigmac.getBun();

        //Then
        Assertions.assertEquals(2, burgersAmount);
        Assertions.assertEquals(2, ingredientsAmount);
        Assertions.assertEquals("With sezame", bun);

    }



}
