package ru.java_core_1.homework.fomin;

public class Cat extends Animal {

    Cat(String name) {
        super(name);
        maxDistance = 200;
        maxSwimLength = 0;
        maxJumpHeight = 2;
    }

    Cat(String name, double maxDistance, double maxSwimLength, double maxJumpHeight) {
        super(name);
        this.maxDistance = maxDistance;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpHeight = maxJumpHeight;
    }

}
