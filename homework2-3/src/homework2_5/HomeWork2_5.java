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
        System.out.println("Time difference is " + Math.abs(timeOfFirstMethod - timeOfSecondMethod) + "milliseconds");
    }

    private static float[] generateArray() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1F;
        return arr;
    }

    protected static float[] calculatedValuesOfArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    private static float[] firstPartOfArr(float[] arr) {
        return Arrays.copyOfRange(arr, 0, h);
    }

    private static float[] secondPartOfArr(float[] arr) {
        return Arrays.copyOfRange(arr, h, size);
    }

    private static long firstMethod(float[] startArray) {
        long startTime = System.currentTimeMillis();
        calculatedValuesOfArray(startArray);
        long deltaTime = System.currentTimeMillis() - startTime;
        System.out.println("First method:");
        System.out.println("Elapsed Time of the first method is " + deltaTime + " milliseconds.");
        return deltaTime;
    }

    private static long secondMethod(float[] startArray) {
        long startTime = System.currentTimeMillis();
        long timeAfterDivision, timeAfterCalculationFirstParts, timeAfterCalculationSecondParts, timeAfterAddition;
        float[] firstPart = firstPartOfArr(startArray);
        float[] secondPart = secondPartOfArr(startArray);
        timeAfterDivision = System.currentTimeMillis();
        SpecialThread t1 = new SpecialThread(firstPart);
        t1.start();
        float[] firstPartNew = t1.arr;
        timeAfterCalculationFirstParts = System.currentTimeMillis();
        SpecialThread t2 = new SpecialThread(secondPart);
        t2.start();
        float[] secondPartNew = t2.arr;
        timeAfterCalculationSecondParts = System.currentTimeMillis();
        System.arraycopy(firstPartNew, 0, startArray, 0, h);
        System.arraycopy(secondPartNew, 0, startArray, h, h);
        timeAfterAddition = System.currentTimeMillis();
        System.out.println("Second method:");
        System.out.println("Elapsed Time of the division of array is " + (timeAfterDivision - startTime) + " milliseconds.");
        System.out.println("Elapsed Time of the calculations a new values for the first part is " + (timeAfterCalculationFirstParts - timeAfterDivision) + " milliseconds.");
        System.out.println("Elapsed Time of the calculations a new values for the second part is " + (timeAfterCalculationSecondParts - timeAfterCalculationFirstParts) + " milliseconds.");
        System.out.println("Elapsed Time of the addition into a one array is " + (timeAfterAddition - timeAfterCalculationSecondParts) + " milliseconds.");
        System.out.println("Elapsed Time of the second method is " + (timeAfterAddition - startTime) + " milliseconds.");
        return timeAfterAddition - startTime;
    }

}
