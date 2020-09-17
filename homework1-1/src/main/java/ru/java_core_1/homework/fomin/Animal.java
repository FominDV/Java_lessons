package ru.java_core_1.homework.fomin;

public class Animal {
    private String name;
    protected double maxDistance, maxSwimLength, maxJumpHeight;

    Animal(String name) {
        this.name = name;
    }

    private boolean isPhysicalAbility(double length, double maxLength) {
        if (maxLength >= length) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    //Methods for animal's actions
    public boolean isRunDistance(double distance) {
        return isPhysicalAbility(distance, maxDistance);
    }

    public boolean isSwimDistance(double swimLength) {
        return isPhysicalAbility(swimLength, maxSwimLength);
    }

    public boolean isHighJump(double height) {
        return isPhysicalAbility(height, maxJumpHeight);
    }
}
