package ru.fomin;

public class Water implements Watery {

    private int temperature;

    public Water(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void heatUp(int degreeCount) {
        temperature += degreeCount;
        if (temperature > 100) {
            temperature = 100;
        }
    }

    @Override
    public boolean isBoiled() {
        return temperature >= 100;
    }
}
