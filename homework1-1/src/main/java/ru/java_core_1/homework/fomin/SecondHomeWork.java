package ru.java_core_1.homework.fomin;

import java.util.Arrays;
import java.util.Scanner;

public class SecondHomeWork {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, -7, 22};
        int[] bitArray = new int[10];
        for (int i = 0; i < bitArray.length; i++)
            bitArray[i] = (int) (Math.random() * 2);
        System.out.println("Part1\nPrimal array: " + Arrays.toString(bitArray) + "\nChanged array: " + Arrays.toString(transformedArray(bitArray)));
        int[] emptyAray = new int[8];
        System.out.println("Part2\nFilled array: " + Arrays.toString(fillArray(emptyAray)));
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Part3\nPrimal array: " + Arrays.toString(array3) + "\nChanged array: " + Arrays.toString(multiplyTo2(array3)));
        int[][] squareArray = new int[5][5];
        for (int i = 0; i < squareArray.length; i++)
            for (int j = 0; j < squareArray.length; j++)
                squareArray[i][j] = 0;
        System.out.println("Part4\nPrimal array: ");
        printSquareArray(squareArray);
        System.out.println("Changed Array: ");
        printSquareArray(getUnitArray(squareArray));
        System.out.println("Part5\nPrimal array: " + Arrays.toString(array));
        mostElement(array);
        mostElement2(array);
        int[] array2 = {1, 2, 3, 4, 5, -7, 22};
        System.out.println("Part6\n Primal array: " + Arrays.toString(array2) + "\nTask: 'Left and right sums are equally': " + isEquallySums(array2));

        //part7 show
        System.out.println("Part7\nPrimal array: " + Arrays.toString(array2) + "\nInput the value of offset for array:");
        int offsetValue = scn.nextInt();
        System.out.println("Final array: " + Arrays.toString(offsetOfArray(array2, offsetValue)));
    }

    //part1
    static int[] transformedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 1:
                    array[i] = 0;
                    break;
                case 0:
                    array[i] = 1;
                    break;
                default:
                    System.out.println("Value of array is not correct");
            }
        }
        return array;
    }

    //Part2
    static int[] fillArray(int[] array) {
        for (int i = 0, j = 0; i <= 21; i += 3, j++) array[j] = i;
        return array;
    }

    //Part3
    static int[] multiplyTo2(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) array[i] *= 2;
        return array;
    }

    //Part4
    static int[][] getUnitArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[array.length - i - 1][i] = 1;
        }
        return array;
    }

    //Part5 Variant1
    static void mostElement(int[] array) {
        int maxElement = array[0];
        int minElement = array[0];
        for (int arrayValue : array) {
            if (arrayValue > maxElement) maxElement = arrayValue;
            if (arrayValue < minElement) minElement = arrayValue;
        }
        System.out.println("Variant 1");
        System.out.println("Maximum element of array is " + maxElement);
        System.out.println(("Minimum element of array is " + minElement));
    }

    //Part5 Variant2
    static void mostElement2(int[] array) {
        Arrays.sort(array);
        System.out.println("Variant 2\nMaximum element of array is " + array[array.length - 1] + "\nMinimum element of array is " + array[0]);
    }

    //part6
    static boolean isEquallySums(int[] array) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < array.length - 1; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int k = i; k >= 0; k--) sumLeft += array[k];
            for (int j = i + 1; j < array.length; j++) sumRight += array[j];
            if (sumLeft == sumRight) break;
        }
        return (sumLeft == sumRight);
    }

    //part7
    static int[] offsetOfArray(int[] array, int n) {
        int value;
        if (n < 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                value = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = value;
            }
        } else {
            for (int i = 0; i < n; i++) {
                value = array[array.length - 1];
                for (int j = 1; j < array.length; j++) {
                    array[array.length - j] = array[array.length - 1 - j];
                }
                array[0] = value;
            }
        }
        return array;
    }

    //Special method
    static void printSquareArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
}
