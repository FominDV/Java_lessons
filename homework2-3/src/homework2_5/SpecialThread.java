package homework2_5;

public class SpecialThread extends Thread {
    protected float[] arr;
    protected long startTime;
    protected long deltaTime;
    private int startIndex;

    public SpecialThread(float[] arr, int startIndex) {
        this.arr = arr;
        this.startIndex=startIndex;
        start();
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        arr = HomeWork2_5.calculatedValuesOfArray(arr, startIndex);
        deltaTime = System.currentTimeMillis() - startTime;
    }
}
