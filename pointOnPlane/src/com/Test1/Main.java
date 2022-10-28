package com.Test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        pointOnPlane a = new pointOnPlane();
        double A = 0.0;
        A += a.xSet(4);
        A += a.ySet(12);
        a.printPoint();
    }
}