package com.Training;

public class Rectangle extends Square {
    double b;
    public Rectangle(double a, double b) {
        super(a);
        this.b = b;
    }

    @Override
    public String toString() {
        return super.toString() + " и " + b;
    }
    double diagonalLength() {
        return Math.sqrt(a * a + b * b);
    }
    double areaLength() {
        return a * b;
    }
}
