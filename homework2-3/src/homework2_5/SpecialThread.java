package homework2_5;

public class SpecialThread extends Thread {
    protected float[] arr;

    public SpecialThread(float[] arr) {
        this.arr = arr;
    }

    public SpecialThread(Runnable target) {
        arr = HomeWork2_5.calculatedValuesOfArray(arr);
    }
}
