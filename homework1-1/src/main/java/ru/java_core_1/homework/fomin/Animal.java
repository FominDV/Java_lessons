package ru.java_core_1.homework.fomin;

public class Animal {
    String name;

    public Animal() {
        name = "Animal";
    }

    public Animal(String name) {
        this.name = name;
    }

    void swim(int length) {
        System.out.println(name + " swam " + length + " metres");
    }

    void run(int length) {
        System.out.println(name + " ran " + length + " metres");
    }
}
