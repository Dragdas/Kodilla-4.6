package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape{

    private double radius;
    private String name = "Circle";

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(name, circle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, name);
    }
}
