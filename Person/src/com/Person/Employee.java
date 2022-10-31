package com.Person;

public class Employee extends Person {

 private String company;

 public Employee(String name, int age, String company) {
  super(name, age);
  this.company = company;
 }

 @Override
 public String toString() {
  return "(" + getName() + "," + " " + getAge() + "," + " " + company + ")";
 }
}
