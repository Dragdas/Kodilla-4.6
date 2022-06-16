package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite {

    @Test
    public void testGetValue(){

        //Given
        SimpleProduct product = new SimpleProduct("Product 2", 15);
        SimpleItem simpleItem = new SimpleItem(product,5);

        //When
        double value = simpleItem.getValue();

        //then
        Assertions.assertEquals(75, value);

    }

}
