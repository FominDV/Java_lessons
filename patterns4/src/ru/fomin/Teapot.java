package ru.fomin;

public class Teapot {

    private int degreeCountForHeatingUp;

    public Teapot(int degreeCountForHeatingUp) {
        this.degreeCountForHeatingUp = degreeCountForHeatingUp;
    }

    public void makeBoilingWater(Watery watery) {
        System.out.println("Boiling it is started");
        while (!watery.isBoiled()) {
            watery.heatUp(degreeCountForHeatingUp);
            System.out.printf("Degree was heat by %s.\n", degreeCountForHeatingUp);
        }
        System.out.println("It is boiled: " + watery.isBoiled());
    }

}
