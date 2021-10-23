package ru.fomin;

public class Ice {

    private int temperature;

    public Ice(int degreeCount) {
        this.temperature = degreeCount;
    }

    public void changeTemperature(int degreeDiff) {
        temperature += degreeDiff;
        if (temperature > 0) {
            temperature = 0;
        }
    }

    public void melt() {
        if (temperature == 0) {
            System.out.println("Ice was melted");
        } else {
            System.out.printf("Ice can not be melted, because the temperature of ice is %d!", temperature);
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
