package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArraysTask1 array1 = new ArraysTask1(20);
        array1.fillArray(100, 20);

        System.out.println(A(3,2));
    }

    public static long A(long n, long m) {
        if(n == 0)
            return m + 1;
        else if (n != 0 && m == 0)
            return A(n - 1, 1);
        else if (n > 0 && m > 0)
            return A(n - 1, A(n, m - 1));
        else
            return -1;
    }
}