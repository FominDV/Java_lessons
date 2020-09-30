package com.company;

import java.util.Arrays;

public class HomeWork_2_2 {
    private static final String LINE = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

    public static void main(String[] args) {
        String[][] stringArr = stringDoubleArr(LINE);
        System.out.println("String array[][]:");
        for (String[] arr : stringArr) {
            System.out.print(Arrays.toString(arr) + "\n");
        }
        int[][] intArr = convertStringArrToIntArr(stringArr);
        System.out.println("Integer array[][]:");
        for (int[] arr : intArr) {
            System.out.print(Arrays.toString(arr) + "\n");
        }
        System.out.println("Sum of elements integer array is " + getSumOfIntArr(intArr));
        System.out.println("Sum of elements integer array is " + getDivision(getSumOfIntArr(intArr)));
    }

    static String[][] stringDoubleArr(String line) {
        String[] stringFirstArr = line.split("\n");
        String[][] stringSecondArr = new String[stringFirstArr.length][stringFirstArr.length];
        for (int i = 0; i < stringFirstArr.length; i++) {
            stringSecondArr[i] = stringFirstArr[i].split(" ");
        }
        return stringSecondArr;
    }

    static int[][] convertStringArrToIntArr(String[][] stringArr) {
        int[][] intArr = new int[stringArr.length][stringArr[0].length];
        for (int i = 0; i < stringArr.length; i++) {
            for (int j = 0; j < stringArr[i].length; j++) {
                intArr[i][j] = Integer.parseInt(stringArr[i][j]);
            }
        }
        return intArr;
    }

    static int getSumOfIntArr(int[][] intArr) {
        int sum = 0;
        for (int[] interIntArr : intArr) {
            for (int value : interIntArr) {
                sum += value;
            }
        }
        return sum;
    }

    static double getDivision(int sum) {
        return sum / 2;
    }
}
