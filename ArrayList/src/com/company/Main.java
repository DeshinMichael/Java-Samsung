package com.company;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Employee> arrayEmployees = new ArrayList<>();
        int kEmployees = 3;
        for (int i = 0; i < kEmployees; i++) {
            String employee = in.nextLine();
            String[] s = employee.split(" ");
            arrayEmployees.add(new Employee(s[0],s[1],Long.parseLong(s[2]),Long.parseLong(s[3])));
        }
        arrayEmployees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.surname.compareTo(o2.surname);
            }
        });

        ArrayOfEmployees arrayOfEmployees = new ArrayOfEmployees(arrayEmployees);

        arrayEmployees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return String.valueOf(o1.dateOfBirth/10000).compareTo(String.valueOf(o2.dateOfBirth/10000));
            }
        });

        arrayOfEmployees.delete("Сидоров");

        arrayOfEmployees.print();

//        while (!s.equals("exit")){
//            String[] data = s.split(" ");
//            for (int i = 2; i < data.length; i++) {
//                s += " " + data[i];
//            }
//            arrayList.add(
//                    new DayOfCalendar(Integer.parseInt(data[0]),
//                            Integer.parseInt(data[1]), data[2])
//            );
//            s = in.nextLine();
//        }
//        System.out.println();
//        Collections.sort(arrayList);
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.print(arrayList.get(i));
//        }
//        arrayList.sort(new MyComparator());
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.print(arrayList.get(i));
//        }
    }
}