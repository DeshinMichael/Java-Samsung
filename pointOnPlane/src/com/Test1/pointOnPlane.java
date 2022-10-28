package com.Test1;

public class pointOnPlane {

    private double x;
    private double y;

    public void printPoint() {
        System.out.println(x + " " + y);
    }
    public double xSet(double x) {
        this.x = x;
        return this.x;
    }
    public double ySet(double y) {
        this.y = y;
        return this.y;
    }
}
