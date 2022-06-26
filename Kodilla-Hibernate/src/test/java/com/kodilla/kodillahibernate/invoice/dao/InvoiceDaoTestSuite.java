package com.kodilla.kodillahibernate.invoice.dao;


import com.kodilla.kodillahibernate.invoice.Invoice;
import com.kodilla.kodillahibernate.invoice.Item;
import com.kodilla.kodillahibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){
        //GIVEN
        Product coke = new Product("Coca- cola");
        Product burger = new Product("Burger");
        Product fries = new Product("Fries");

        Item cokeItem = new Item(coke, BigDecimal.valueOf(5.48), 1);
        Item burgerItem = new Item(burger, BigDecimal.valueOf(12),1);
        Item friesItem = new Item(fries, BigDecimal.valueOf(6), 2);

        Invoice invoice = new Invoice("1");
        invoice.getItems().addAll( List.of(cokeItem, burgerItem, friesItem) );

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        //Cleanup
        try {
            invoiceDao.deleteById(invoiceId);
        } catch (Exception e) {
            //do nothing
        }

    }


}
