package com.company;

import java.util.Random;

public class ArraysTask1 {
    int a[];
    public ArraysTask1(int n){
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
    //TODO напишите метод линейного поиска элемента num в массиве
    public int linearSearch(int num){
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == num) {
                index = i;
                break;
            }
        }
        return index;
    }
}
