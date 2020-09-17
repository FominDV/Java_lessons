package ru.homework7;

public class Cat {
    private String name;
    private int appetite;
    Cat(String name, int appetite){
        this.name=name;
        this.appetite=appetite;
    }
    protected void eat(Plate plate){
        plate.decreaseFood(appetite);
    }
}
