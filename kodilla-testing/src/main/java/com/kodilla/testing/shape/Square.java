package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape{

    private double sideLenght;
    private String name = "Square";

    public Square(double sideLenght) {
        this.sideLenght = sideLenght;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(sideLenght,2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Double.compare(square.sideLenght, sideLenght) == 0 && Objects.equals(name, square.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLenght, name);
    }
}
