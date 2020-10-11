package homework2_5;

import java.util.Arrays;

public class HomeWork2_5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        long timeOfFirstMethod, timeOfSecondMethod;
        float[] arr = generateArray();
        timeOfFirstMethod = firstMethod(arr);
        timeOfSecondMethod = secondMethod(arr);
        System.out.println("Time difference is " + Math.abs(timeOfFirstMethod - timeOfSecondMethod) + " milliseconds");
    }

    private static float[] generateArray() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        return arr;
    }

    protected static float[] calculatedValuesOfArray(float[] array) {
        float[] newArr=Arrays.copyOf(array,array.length);
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = (float) (newArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return newArr;
    }

    private static float[] firstPartOfArr(float[] arr) {
        return Arrays.copyOfRange(arr, 0, h);
    }

    private static float[] secondPartOfArr(float[] arr) {
        return Arrays.copyOfRange(arr, h, size);
    }

    private static long firstMethod(float[] startArray) {
        long startTime = System.currentTimeMillis();
        float[] calculatedArray= calculatedValuesOfArray(startArray);
        long deltaTime = System.currentTimeMillis() - startTime;
        System.out.println("First method:");
        System.out.println("Elapsed Time of the first method is " + deltaTime + " milliseconds.");
        return deltaTime;
    }

    private static long secondMethod(float[] startArray) {
        long startTime = System.currentTimeMillis();
        long timeAfterDivision, timeAfterCalculation, timeAfterAddition;
        float[] firstPart = firstPartOfArr(startArray);
        float[] secondPart = secondPartOfArr(startArray);
        timeAfterDivision = System.currentTimeMillis();
        SpecialThread t1 = new SpecialThread(firstPart);
        t1.start();
        SpecialThread t2 = new SpecialThread(secondPart);
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timeAfterCalculation = System.currentTimeMillis();
        System.arraycopy(firstPart, 0, startArray, 0, h);
        System.arraycopy(secondPart, 0, startArray, h, h);
        timeAfterAddition = System.currentTimeMillis();
        System.out.println("Second method:");
        System.out.println("Elapsed Time of the division of array is " + (timeAfterDivision - startTime) + " milliseconds.");
        System.out.println("Elapsed Time of the calculations a new values for the first part is " + t1.deltaTime + " milliseconds.");
        System.out.println("Elapsed Time of the calculations a new values for the second part is " + t2.deltaTime + " milliseconds.");
        System.out.println("Elapsed Time of the addition into a one array is " + (timeAfterAddition - timeAfterCalculation) + " milliseconds.");
        System.out.println("Elapsed Time of the second method is " + (timeAfterAddition - startTime) + " milliseconds.");
        return timeAfterAddition - startTime;
    }

}
