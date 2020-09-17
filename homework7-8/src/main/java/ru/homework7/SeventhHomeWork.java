package ru.homework7;

public class SeventhHomeWork {
    public static void main(String[] arg) {
        Cat cat = new Cat("Bars", 150);
        Plate plate = new Plate(100);
        plate.info();
        cat.info();
        cat.eat(plate);
        plate.info();
        cat.info();
    }
}
