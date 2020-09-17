package ru.homework7;

public class Plate {
    private int food;
    Plate(int food){
        this.food=food;
    }
    protected void info(){
        System.out.println("The count of the food in this plate is "+food);
    }
    protected void decreaseFood(int appetite){
        food-=appetite;
    }
}
