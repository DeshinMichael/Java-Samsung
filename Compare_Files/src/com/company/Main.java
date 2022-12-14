package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        FileInputStream file1;
        FileInputStream file2;
        try {
            file1 = new FileInputStream("first.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            file2 = new FileInputStream("second.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder strFile1 = new StringBuilder();
        StringBuilder strFile2 = new StringBuilder();


        int c1;
        while (true) {
            try {
                if ((c1 = file1.read()) == -1)
                    break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            char c2 = (char) c1;
            strFile1.append(c2);
        }
        try {
            file1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        int s1;
        while (true) {
            try {
                if ((s1 = file2.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            char s2 = (char) s1;
            strFile2.append(s2);
        }
        try {
            file2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        int kDif = 0;
        if (strFile1.toString().equals(strFile2.toString())) {
            System.out.println("true");
        } else {
            System.out.println("false");
            if (strFile1.length() == strFile2.length()) {
                for (int i = 0; i < strFile1.length(); i++) {
                    if (strFile1.charAt(i) != strFile2.charAt(i)) {
                        System.out.print(strFile1.charAt(i) + " " + strFile2.charAt(i) + " ");
                        kDif++;
                    }
                }
                System.out.println();
            } else if (strFile1.length() > strFile2.length()) {
                for (int i = 0; i < strFile2.length(); i++) {
                    if (strFile1.charAt(i) != strFile2.charAt(i)) {
                        System.out.print(strFile1.charAt(i) + " " + strFile2.charAt(i) + " ");
                        kDif++;
                    }
                }
                for (int i = strFile2.length(); i < strFile1.length(); i++) {
                    System.out.print(strFile1.charAt(i) + " ");
                    kDif++;
                }
                System.out.println();
            } else {
                for (int i = 0; i < strFile1.length(); i++) {
                    if (strFile1.charAt(i) != strFile2.charAt(i)) {
                        System.out.print(strFile1.charAt(i) + " " + strFile2.charAt(i) + " ");
                        kDif++;
                    }
                }
                for (int i = strFile1.length(); i < strFile2.length(); i++) {
                    System.out.print(strFile2.charAt(i) + " ");
                    kDif++;
                }
                System.out.println();
            }
            System.out.println(kDif);
        }
    }
}