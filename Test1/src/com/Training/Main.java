package com.Training;

public class Main {
    public static void main(String[] args) {
        NDrob frac2 = new NDrob(4,5);
        NDrob frac3 = new NDrob(3,5);
        NDrob frac1 = frac2.del(frac3);
        frac1.printDrob();
//        frac1 = frac2.add(frac3);
//        frac1.printDrob();
        NDrob frac4 = frac2.sub(frac3);
        frac4.printDrob();
//        NDrob.count = 3;
//        System.out.println(frac3.count);


//        Square square1 = new Square(6);
//        Rectangle rectangle = new Rectangle(3,6);
//        System.out.println(square1);
//        System.out.println(rectangle);
//        System.out.println(square1.diagonalLength());
//        System.out.println(rectangle.diagonalLength());
//        System.out.println(square1.areaLength());
//        System.out.println(rectangle.areaLength());
    }
}

