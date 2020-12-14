package lesson1;

import java.util.Scanner;

public class Tasks_1_2 {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        String[] stringArray = {"1", "2", "3", "40", "50", "60"};
        //task 1
        printArray(stringArray);
        setIndexesForSwap(stringArray);
        printArray(stringArray);

        // task 2

    }


    /*1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);*/
    private static <T> T[] swapElementsOfArray(T[] array, int index1, int index2) {
        if (index1 == index2) return array;
        T bufferElement = array[index1];
        array[index1] = array[index2];
        array[index2] = bufferElement;
        return array;
    }

    private static boolean isNotValidIndex(int index, int arrayLength) {
        if (index < 0 || index >= arrayLength) return true;
        else return false;
    }

    private static <T> void printArray(T[] array) {
        System.out.println("Array of " + array.getClass().getSimpleName());
        for (T element : array) System.out.print(element + "; ");
        System.out.println("");
    }

    private static <S> void setIndexesForSwap(S[] array) {
        int[] indexes = new int[2];
        int i=0;
        while (true) {
            System.out.println("Inter index number "+(i+1));
            try {
                indexes[i] = read.nextInt();
                if(isNotValidIndex(indexes[i], array.length)) throw new RuntimeException();
            }catch (RuntimeException e){
                    System.out.println("indexes should be integer numbers, greater than 0 and less than " + (array.length - 1));
                    continue;
            }
            if(i==1) break; else i++;
        }
        swapElementsOfArray(array,indexes[0],indexes[1]);
    }
}
