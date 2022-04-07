package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape{

    private double base;
    private double height;
    private String name = "Triangle";

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 0.5*base*height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0 && Double.compare(triangle.height, height) == 0 && Objects.equals(name, triangle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height, name);
    }
}
