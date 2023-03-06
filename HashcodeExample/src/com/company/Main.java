package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        String[] s = in.nextLine().split(" ");
        for (String name: s) {
            hashSet.add(name);
            treeSet.add(name);
            //System.out.println(name.hashCode() + " ");
        }
        System.out.println(hashSet);
        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next().hashCode() + " ");
        }
        System.out.println(treeSet);
    }
}