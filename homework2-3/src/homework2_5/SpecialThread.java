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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            deltaTime = System.currentTimeMillis() - startTime;
        }
        deltaTime = System.currentTimeMillis() - startTime;
    }
}
