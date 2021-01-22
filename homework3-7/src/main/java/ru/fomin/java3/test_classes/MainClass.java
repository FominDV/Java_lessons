package ru.fomin.java3.test_classes;

import ru.fomin.java3.testing_framework.engine.Testing;

public class MainClass {
    public static void main(String[] args) {
        Testing.start(TestClass.class);
        System.out.println("----------------------------------------------");
        Testing.start(TestClass.class.getName());
        System.out.println("----------------------------------------------");
        Testing.start(TestClass2.class);
        System.out.println("----------------------------------------------");
        Testing.start(TestClass2.class.getName());
        System.out.println("----------------------------------------------");
        Testing.start(TestClass3.class);
        System.out.println("----------------------------------------------");
    }
}
