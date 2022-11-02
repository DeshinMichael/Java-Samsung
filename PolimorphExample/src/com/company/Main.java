package com.company;

public class Main {
    public static Animal randAnimal() {
        int k = (int) (Math.random() * 6);
        switch (k) {
            case 0: return new Pike();
            case 1: return new Bird();
            case 2: return new Fish();
            case 3: return new Sparrow();
            case 4: return new Eagle();
            case 5: return new Carp();
        }
        return null;
    }
    public static void main(String[] args) {
//        Animal a = new Animal();
//        Fish f = new Fish();
//        Bird b = new Bird();
//        Pike p = new Pike();
//        Carp c = new Carp();
//        Sparrow s = new Sparrow();
//        Eagle e = new Eagle();
        Animal [] animals = new Animal[10];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = randAnimal();
        }
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].className() + " " + animals[i].move() + " " + animals[i].feed() + " " + animals[i].breathe());
        }
    }
}