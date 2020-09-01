package ru.java_core_1.homework.fomin;

import java.util.Arrays;
import java.util.Scanner;

public class SecondHomeWork {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input the value of offset for array:");
        int offsetValue = scn.nextInt();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Primal array: "+Arrays.toString(array)+"\nFinal array: "+Arrays.toString(offsetOfArray(array, offsetValue)));
    }

    //part7
    static int[] offsetOfArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int value = array[0];
            array[0] = array[array.length - 1];
            for (int j = 1; j <= array.length - 1; j++) {
                array[array.length-j]=array[array.length-1-j];
            }
            array[1]=value;
        }
        return array;
    }
}
