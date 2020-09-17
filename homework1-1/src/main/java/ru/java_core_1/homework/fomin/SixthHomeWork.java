package ru.java_core_1.homework.fomin;

import java.util.Scanner;

/*1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.*/
public class SixthHomeWork {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        verifyingDistancesForAnimals();
        read.close();
    }

    static Animal[] getArrayOfAnimals() {
        Animal cat1 = new Cat("Bars");
        Animal cat2 = new Cat("Cyber-cat", 300, 300.5, 20.2);
        Animal dog1 = new Dog("Bobby");
        Animal dog2 = new Dog("FatChappy", 9.45, 0, 0.07);
        Animal[] animals = {cat1, cat2, dog1, dog2};
        return animals;
    }

    static void printPhysicalAbilities(Animal[] animals, double distance, double swimLength, double height) {
        String typeOfAnimal;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof Cat) {
                typeOfAnimal = " the cat ";
            } else {
                typeOfAnimal = " the dog ";
            }
            System.out.println(animals[i].getName() + typeOfAnimal + "can:\nRun " + distance + " metres: " + animals[i].isRunDistance(distance)
                    + "\nSwim " + swimLength + " metres: " + animals[i].isSwimDistance(swimLength)
                    + "\nJump " + height + " metres: " + animals[i].isHighJump(height) + "\n");
        }
    }

    static void verifyingDistancesForAnimals() {
        double distance, swimLength, height;
        System.out.println("Input distance for run:");
        distance = inputDouble();
        System.out.println("Input swim length:");
        swimLength = inputDouble();
        System.out.println("Input height for jump:");
        height = inputDouble();
        printPhysicalAbilities(getArrayOfAnimals(), distance, swimLength, height);
    }

    static Double inputDouble() {
        do {
            if (read.hasNextDouble()) {
                return read.nextDouble();
            } else {
                read.nextLine();
                System.out.println("It isn't decimal number!");
            }
        } while (true);
    }
}
