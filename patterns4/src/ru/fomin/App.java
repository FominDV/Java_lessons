package ru.fomin;

public class App {

    public static void main(String[] args) {
        Teapot teapot = new Teapot(10);
        Watery water = new Water(15);
        Watery ice = new IceToWaterAdapter(-27);
        System.out.println("Boiling water was started");
        teapot.makeBoilingWater(water);
        System.out.println("Boiling ice was started");
        teapot.makeBoilingWater(ice);
    }

}
