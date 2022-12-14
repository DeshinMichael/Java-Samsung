package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        s = s.replaceAll("\\s","");
        int mid = s.length()/2;
        int i = 0;
        int j = s.length() - 1;
        boolean check = true;
        if (s.length()%2 == 0) {
            while(i <= mid){
                if (s.charAt(i) != s.charAt(j)){
                    check = false;
                    break;
                }
                j--;
                i++;
            }
        }else {
            while(i < mid + 1){
                if (s.charAt(i) != s.charAt(j)){
                    check = false;
                    break;
                }
                j--;
                i++;
            }
        }
        if (check) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}