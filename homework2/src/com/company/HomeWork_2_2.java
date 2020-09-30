package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork_2_2 {
    private static final String LINE = "10 3 1 2\n2 3 2 t2\n5 6 7 1\n300 3 1 0";
    private static String userLine = "";

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Start line:\n" + LINE);
        try {
            new ProcessingString(LINE);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1");
        } catch (NumberFormatException e) {
            System.out.println("2");
        }
        System.out.println("Enter string, between values must be spaces:");
        for (int i = 1; i <= 4; i++) {
            System.out.println("Enter string of four values number " + i);
            userLine += read.nextLine() + "\n";
        }
        try {
            new ProcessingString(userLine);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1");
        } catch (NumberFormatException e) {
            System.out.println("2");
        }
    }
}
