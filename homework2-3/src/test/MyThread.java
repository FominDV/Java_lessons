package test;

public class MyThread extends Thread{
    @Override
    public void run() {


    }
    public void calculateTime1 (double [] arr, int index){

        for (int i = 0; i < arr.length; i++) {
            if(!isAlive()){
                System.out.println("DEAD");
            }
            arr[i]= arr[i] * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2);
            index++;

        }
    }
}
