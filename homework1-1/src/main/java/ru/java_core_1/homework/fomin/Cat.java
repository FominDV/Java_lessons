package ru.java_core_1.homework.fomin;

public class Cat extends Animal {
    public Cat() {
        name = "Cat";
    }

    final int MAX_RUN = 200;
    final int MAX_SWIM = 0;

    public Cat(String name) {
        super(name);
    }
}
