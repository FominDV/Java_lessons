package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork_2_2 extends ProcessingString {
    private static final String LINE = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static String userLine = "";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Start line:\n" + LINE);
        try {
            processingString(LINE);
        } catch (SizeOfStringArrayException e) {
            System.err.println(e.getMessage());
        } catch (ConvertStringArrayToIntArrayException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\nEnter string, between values must be spaces:");
        for (int i = 1; i <= 4; i++) {
            System.out.println("Enter string of four values number " + i);
            userLine += read.nextLine() + "\n";
        }
        try {
            processingString(userLine);
        } catch (SizeOfStringArrayException e) {
            System.err.println(e.getMessage());
        } catch (ConvertStringArrayToIntArrayException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
