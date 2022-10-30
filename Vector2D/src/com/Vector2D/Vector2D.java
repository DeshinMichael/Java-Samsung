package com.Vector2D;

import java.util.Locale;

public class Vector2D {

    public double vX;
    public double vY;
    public static int count = 0;

    public Vector2D() {
        vX = 1;
        vY = 1;
        count++;
    }

    public Vector2D(double vX, double vY) {
        this.vX = vX;
        this.vY = vY;
        count++;
    }
    public Vector2D(Vector2D v) {
        this.vX = v.vX;
        this.vY = v.vY;
        count++;
    }
    public void print() {
        System.out.println(String.format(Locale.US,
                "(%.2f, %.2f)", vX, vY));
    }
    public double length() {
        return Math.sqrt(vX * vX + vY * vY);
    }
    public Vector2D add(Vector2D v) {
        vX = vX + v.vX;
        vY = vY + v.vY;
        return v;
    }
    public Vector2D sub(Vector2D v) {
        vX = vX - v.vX;
        vY = vY - v.vY;
        return v;
    }
    public double scale(double scaleFactor) {
        vX = vX * scaleFactor;
        vY = vY * scaleFactor;
        return 0.0;
    }
    public double normalized() {
        double length = Math.sqrt(vX * vX + vY * vY);
        vX = vX* 1/length;
        vY = vY* 1/length;
        return 0.0;
    }
    public double dotProduct(Vector2D v) {
        return vX * v.vX + vY * v.vY;
    }
}

