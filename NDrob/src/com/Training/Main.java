package com.Training;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NDrob frac2 = new NDrob(4,5);
        NDrob frac3 = new NDrob(3,5);
        NDrob frac1 = frac2.del(frac3);
        frac1.printDrob();
        frac1 = frac2.sum(frac3);
        frac1.printDrob();
        frac1 = frac2.sub(frac3);
        frac1.printDrob();
    }
}

