package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTest {

    @Test
    void TestBasicPizzaOrder(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //when
        BigDecimal cost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getIngredients();

        //then
        assertEquals(new BigDecimal(15), cost);
        assertEquals("Pizza with: cheese + sauce", pizzaDescription);
    }

    @Test
    void TestPizzaWithBacon(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BaconDecorator(pizzaOrder);

        //when
        BigDecimal cost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getIngredients();

        //then
        assertEquals(new BigDecimal(20), cost);
        assertEquals("Pizza with: cheese + sauce + bacon", pizzaDescription);
    }

    @Test
    void TestPizzaWithBaconAndMushrooms(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BaconDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        //when
        BigDecimal cost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getIngredients();

        //then
        assertEquals(new BigDecimal(23), cost);
        assertEquals("Pizza with: cheese + sauce + bacon + mushrooms", pizzaDescription);
    }
}