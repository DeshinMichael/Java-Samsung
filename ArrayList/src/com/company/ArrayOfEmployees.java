package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayOfEmployees {
    ArrayList<Employee> arrayEmployees;

    public ArrayOfEmployees(ArrayList<Employee> arrayEmployees) {
        this.arrayEmployees = arrayEmployees;
    }

    public void print() {
        for (int i = 0; i < arrayEmployees.size(); i++) {
            System.out.println(arrayEmployees.get(i));
        }
    }

    public void delete(String surname) {
        for (int i = 0; i < arrayEmployees.size(); i++) {
            if(arrayEmployees.get(i).surname.equals(surname)){
                arrayEmployees.remove(arrayEmployees.get(i));
            }
        }
    }
}
