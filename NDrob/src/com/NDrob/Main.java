package com.NDrob;

public class Main {
    public static void main(String[] args) {

        NDrob frac1 = new NDrob();
        NDrob frac2 = new NDrob(4,5);
        NDrob frac3 = new NDrob(1,2);

        frac1 = frac2.del(frac3);
        frac1.printDrob();

        frac1 = frac2.add(frac3);
        frac1.printDrob();
    }
}