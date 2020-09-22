package ru.homework7;

public class SeventhHomeWork {
    public static void main(String[] arg) {
        Cat cats[] = cats();
        Plate plate = new Plate(115);
        plate.info();
        catsEatingFromPlate(cats, plate);
        infoAboutCats(cats);
        plate.increaseFood(45);
        catsEatingFromPlate(cats, plate);
        infoAboutCats(cats);
    }

    static Cat[] cats() {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Bars", 15);
        cats[1] = new Cat("Carel", 35);
        cats[2] = new Cat("Suse", 20);
        cats[3] = new Cat("Parker", 50);
        cats[4] = new Cat("Leonard", 40);
        return cats;
    }

    static void catsEatingFromPlate(Cat[] cats, Plate plate) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.info();
        }
    }

    static void infoAboutCats(Cat[] cats) {
        for (int i = 0; i < cats().length; i++) {
            cats[i].info();
        }
    }
}
