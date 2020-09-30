package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork_2_2 {
    private static final String LINE = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0 5";
    private static String userLine = "";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Start line:\n" + LINE);
        try {
            ProcessingString.processingString(LINE);
        } catch (SizeOfStringArrayException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("2");
        }
        System.out.println("\nEnter string, between values must be spaces:");
        for (int i = 1; i <= 4; i++) {
            System.out.println("Enter string of four values number " + i);
            userLine += read.nextLine() + "\n";
        }
        try {
            ProcessingString.processingString(userLine);
        } catch (SizeOfStringArrayException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("2");
        }
    }
}
