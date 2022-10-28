package com.Test1;

public class pointOnPlane {

    private double x;
    private double y;

    public void printPoint() {
        System.out.println(x + " " + y);
    }
    public double getX(double x) {
        this.x = x;
        return x;
    }
    public double getY(double y) {
        this.y = y;
        return y;
    }
}
