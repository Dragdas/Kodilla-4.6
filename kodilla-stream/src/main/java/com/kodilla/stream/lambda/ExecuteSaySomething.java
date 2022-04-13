package com.kodilla.stream.lambda;

public class ExecuteSaySomething implements  Executor{
    @Override
    public void process() {
        System.out.println("Say something as executor!");
    }
}
