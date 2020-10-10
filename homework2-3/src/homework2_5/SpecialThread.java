package homework2_5;

public class SpecialThread extends Thread {
    protected float[] arr;

    public SpecialThread(float[] arr) {
        super();
        this.arr = HomeWork2_5.calculatedValuesOfArray(arr);
    }
}
