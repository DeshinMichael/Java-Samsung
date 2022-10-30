package com.pointOnPlane;

public class Main {
    public static void main(String[] args) {

        pointOnPlane a = new pointOnPlane();
        double A = 0.0;
        A += a.getX(4);
        A += a.getY(12);
        a.printPoint();
    }
}