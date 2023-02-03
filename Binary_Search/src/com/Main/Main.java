package com.Main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        binarySearchFirstAndLast();
    }
    public static void binarySearchInMassive() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] n = new Integer[N];
        Integer[] k = new Integer[K];

        for (int i = 0; i < N; i++) {
            n[i] = sc.nextInt();
        }
        for (int i = 0; i < K; i++) {
            k[i] = sc.nextInt();
        }

        for (int i = 0; i < K; i++) {
            if(Arrays.binarySearch(n, k[i]) >= 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static void binarySearchFirstAndLast() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Integer[] n = new Integer[N];
        Integer[] m = new Integer[M];

        for(int i = 0; i < N; i++){
            n[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            m[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(n, m[i]) >= 0) {
                int index = Arrays.binarySearch(n, m[i]);
                int iFirst = index;
                int iLast = index;
                while (index >= 1 && m[i].equals(n[index - 1])) {
                    index--;
                    iFirst = index;
                }
                index = iLast;
                while (index + 1 < M && m[i].equals(n[index + 1])) {
                    index++;
                    iLast = index;
                }
                System.out.print(iFirst + 1 + " ");
                System.out.println(iLast + 1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}