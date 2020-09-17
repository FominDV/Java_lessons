package ru.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        full = false;
    }

    protected void info() {
        System.out.println(name + " is full: " + full);
    }

    protected void eat(Plate plate) {
        if (plate.isEnoughFood(appetite)) {
            plate.decreaseFood(appetite);
            full = true;
            System.out.println(name + " ate.");
        } else {
            System.out.println(name + " didn't eat.");
        }
    }
}
