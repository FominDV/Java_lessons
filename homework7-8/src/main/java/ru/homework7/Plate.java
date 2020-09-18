package ru.homework7;

public class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    protected void info() {
        System.out.println("The count of the food in this plate is " + food);
    }

    protected boolean isEnoughFood(int appetite) {
        if (food >= appetite) {
            return true;
        } else {
            return false;
        }
    }

    /*It's realisation of second task.
    In my opinion if cat is hungry and count of the food is less than appetite of the cat, all food in the plate will be eaten.*/
    protected void decreaseFood(int appetite) {
        if (food < appetite) {
            food = 0;
        } else {
            food -= appetite;
        }
    }

    protected void increaseFood(int quantityFood) {
        food += quantityFood;
    }
}
