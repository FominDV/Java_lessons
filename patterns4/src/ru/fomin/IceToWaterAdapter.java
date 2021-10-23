package ru.fomin;

public class IceToWaterAdapter extends Ice implements Watery {

    private boolean isMelted;

    public IceToWaterAdapter(int degreeCount) {
        super(degreeCount);
    }

    @Override
    public void heatUp(int degreeCount) {
        if (isMelted) {
            int newTemperature = getTemperature() + degreeCount;
            if (newTemperature > 100) {
                newTemperature = 100;
            }
            setTemperature(newTemperature);
            return;
        }
        changeTemperature(degreeCount);
        if (!isMelted && getTemperature() == 0) {
            melt();
            isMelted = true;
        }
    }

    @Override
    public boolean isBoiled() {
        return getTemperature() >= 100;
    }

}
