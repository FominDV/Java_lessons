package test;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main (String[]arg) {
        double [] arr = new double [size];
        Arrays.fill(arr, 1);
        System.out.println(calculateTime(arr)+ " sec");

        double [] arr1 = new double [size];
        Arrays.fill(arr1, 1);
        System.out.println(calculateTimeTwoTreads(arr1)+ " sec");

    }

    static double calculateTime (double  [] arr){
        long currentTime = System.nanoTime();
        calculateArr(arr);
        long lastFrameTime = System.nanoTime();
        System.out.println(checkControlSum(arr));
        return (lastFrameTime - currentTime) * 0.000000001f;
    }

    static double calculateTimeTwoTreads (double [] arr){

        long currentTime = System.nanoTime();
        double [] a1= new double [h];
        double [] a2 = new double [h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        MyThread tread1 = new MyThread();
        MyThread tread2 = new MyThread();
        tread1.start();
        tread1.calculateTime1(a1,0);
        tread2.start();
        tread2.calculateTime1(a2,h);
        try {
            tread1.join();
            tread2.join();

        } catch  (InterruptedException e) {
            e.printStackTrace();}
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(checkControlSum(arr));
        long lastFrameTime = System.nanoTime();
        return (lastFrameTime - currentTime) * 0.000000001f;

    }

    static double checkControlSum (double[] arr) {
        double sum = 0;
        for (double v : arr) {
            sum = sum + v;
        }
        return sum;
    }
    static void calculateArr (double[]arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i]= arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2);

        }
    }



}