package com.company;

import java.util.Arrays;

public class ProcessingString {

    static String[][] getStringDoubleArr(String line) throws SizeOfStringArrayException {
        String[] stringFirstArr = line.split("\n");
        String[][] stringSecondArr = new String[stringFirstArr.length][];
        for (int i = 0; i < stringFirstArr.length; i++) {
            stringSecondArr[i] = stringFirstArr[i].split(" ");
        }
        if (stringFirstArr.length != 4) throw new SizeOfStringArrayException(stringFirstArr.length, 4, 4);
        for (String[] singleStringArray : stringSecondArr) {
            if (singleStringArray.length != 4) throw new SizeOfStringArrayException(singleStringArray.length, 4, 4);
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

    static void processingString(String line) throws SizeOfStringArrayException, NumberFormatException {
        System.out.println("String array[][]:");
        try {
            getStringDoubleArr(line);
        } catch (SizeOfStringArrayException e) {
            throw e;
        }
        String[][] stringArr = getStringDoubleArr(line);
        for (String[] arr : stringArr) {
            System.out.print(Arrays.toString(arr) + "\n");
        }
        System.out.println("Integer array[][]:");
        convertStringArrToIntArr(stringArr);
        int[][] intArr = convertStringArrToIntArr(stringArr);
        for (int[] arr : intArr) {
            System.out.print(Arrays.toString(arr) + "\n");
        }
        System.out.println("Sum of elements integer array is " + getSumOfIntArr(intArr));
        System.out.println("Calculation of division is " + getDivision(getSumOfIntArr(intArr)));
    }
}
