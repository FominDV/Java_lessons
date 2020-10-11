package homework2_5;

public class SpecialThread extends Thread {
    protected float[] arr;
    protected long startTime;
    protected long deltaTime;

    public SpecialThread(float[] arr){
        this.arr=arr;
    }
    @Override
    public void run() {
        startTime=System.currentTimeMillis();
       HomeWork2_5.calculatedValuesOfArray(arr);
        deltaTime = System.currentTimeMillis() - startTime;
    }
}
