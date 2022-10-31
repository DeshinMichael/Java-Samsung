package com.TrianglePerimetr;

import java.util.Locale;
import java.util.Scanner;

public class Geom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.printf("%.10f", Geom.trianglePerimetr(-15809, 20304, 18912, -10503, 10020, 22779));

    }
    static double trianglePerimetr(long x1, long y1, long x2, long y2, long x3, long y3) {
        double P = 0;
        double a = 0;
        double b = 0;
        double c = 0;
        a = segmentLength(x1, y1, x2, y2);
        b = segmentLength(x2, y2, x3, y3);
        c = segmentLength(x3, y3, x1, y1);
        P = a + b + c;
        return P;
    }
    static double segmentLength(long x1, long y1, long x2, long y2) {
        double l = 0;
        double S = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        l += S;
        return l;
    }
}
