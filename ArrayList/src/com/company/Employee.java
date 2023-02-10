package com.company;

public class Employee {
    String surname;
    String name;
    long number;
    long dateOfBirth;

    public Employee(String surname, String name, long number, long dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Фамилия: " + surname + " Имя: " + name + " Телефон: " + number + " Дата рождения: " + dateOfBirth;
    }
}

