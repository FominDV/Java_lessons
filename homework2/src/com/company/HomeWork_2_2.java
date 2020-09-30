package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork_2_2 {
    private static final String LINE = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static String userLine = "";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Start line:\n" + LINE);
        processingString(LINE);
        System.out.println("Enter string, between values must be spaces:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter string of four values number " + i);
            userLine += read.nextLine() + "\n";
        }
        processingString(userLine);
    }

    static String[][] getStringDoubleArr(String line) throws IndexOutOfBoundsException {
        String[] stringFirstArr = line.split("\n");
        String[][] stringSecondArr = new String[stringFirstArr.length][];
        for (int i = 0; i < stringFirstArr.length; i++) {
            stringSecondArr[i] = stringFirstArr[i].split(" ");
        }
        if (stringSecondArr.length != 4) throw new IndexOutOfBoundsException();
        for (String[] singleStringArray : stringSecondArr) {
            if (singleStringArray.length != 4) throw new IndexOutOfBoundsException();
        }
        return stringSecondArr;
    }

    static int[][] convertStringArrToIntArr(String[][] stringArr) throws NumberFormatException {
        int[][] intArr = new int[stringArr.length][];
        for (int i = 0; i < stringArr.length; i++) {
            intArr[i] = new int[stringArr[i].length];
            for (int j = 0; j < stringArr[i].length; j++) {
                try {
                    intArr[i][j] = Integer.parseInt(stringArr[i][j]);
                } catch (NumberFormatException e) {
                    throw e;
                }
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

    static void processingString(String line) {
        System.out.println("String array[][]:");
        try {
            getStringDoubleArr(line);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array's size isn't 4 by 4");
        }
        String[][] stringArr = getStringDoubleArr(line);
        for (String[] arr : stringArr) {
            System.out.print(Arrays.toString(arr) + "\n");
        }
        System.out.println("Integer array[][]:");
        try {
            convertStringArrToIntArr(stringArr);
        } catch (NumberFormatException e) {
            System.out.println("Some elements of string array are not integer numbers");
        }
        int[][] intArr = convertStringArrToIntArr(stringArr);
        for (int[] arr : intArr) {
            System.out.print(Arrays.toString(arr) + "\n");
        }
        System.out.println("Sum of elements integer array is " + getSumOfIntArr(intArr));
        System.out.println("Calculation of division is " + getDivision(getSumOfIntArr(intArr)));
    }
}
