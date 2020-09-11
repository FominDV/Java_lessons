package ru.java_core_1.homework.fomin;

public class Employee {
    String fullName, position, email, phoneNumber;
    int salary, age;

    Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void outDataOfEmployee() {
        System.out.println("Full name: " + fullName + "\nPosition: " + position + "\nemail: " + email + "\nPhone number: " + phoneNumber + "\nSalary: " + salary + " rub\nAge: " + age + " full years\n");
    }
}
