package com.kodilla.kodillaspring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Calculator {


    Display display;

    @Autowired
    public Calculator(Display display) {
        this.display = display;
    }

    public double add(double a, double b){
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double sub(double a, double b){
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    public double mul(double a, double b){
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double div(double a, double b){
        double result = b!=0 ? a/b : 0;
        display.displayValue(result);
        return result;
    }


}
