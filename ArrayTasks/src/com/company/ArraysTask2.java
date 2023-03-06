package com.company;

import java.util.Arrays;
import java.util.Random;


public class ArraysTask2 {
    int a[];
    public ArraysTask2(int n){
        a = new int [n];
    }

    //заполнение n элементов массива случайными числами в диапазоне rand
    public void fillArray(int rand, int n){
        Random random = new Random();
        if (n<=a.length)
            for (int i = 0; i < n; i++) {
                a[i] = random.nextInt(rand);
            }
    }
    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    //TODO напишите метод бинарного поиска элемента num в массиве
    public int binarySearch(int num){
        int lo = 0;
        int hi = a.length - 1;
        int mid = (lo + hi) / 2;
        while (lo < hi) {
            if(a[mid] < num)
                lo = mid;
            if(a[mid] > num)
                hi = mid;
            if(a[mid] == num)
                return mid;
            mid = (lo + hi)/2;
        }
        return -1;
    }

    //TODO напишите метод сортировки массива (можно использовать метод класса Arrays)
    public void sort(int from, int to){
        Arrays.sort(a, from, to);
    }
}