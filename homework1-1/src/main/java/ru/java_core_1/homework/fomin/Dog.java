package ru.java_core_1.homework.fomin;

public class Dog extends Animal {

    Dog(String name) {
        super(name);
        maxDistance = 500;
        maxSwimLength = 10;
        maxJumpHeight = 0.5;
    }

    Dog(String name, double maxDistance, double maxSwimLength, double maxJumpHeight) {
        super(name);
        this.maxDistance = maxDistance;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpHeight = maxJumpHeight;
    }
}
