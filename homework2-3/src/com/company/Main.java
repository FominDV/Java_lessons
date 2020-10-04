package com.company;

import java.util.Random;

public class Main {
    static final String[] UNIQUE_WORDS = {"apple", "sap", "beer", "cash", "summer", "bus", "next", "people", "length", "data", "circle", "monkey", "master"};

    public static void main(String[] args) {
        String[] words = generateArrayOfWords(30, UNIQUE_WORDS);

    }

    static String[] generateArrayOfWords(int size, String[] basicWords) {
        Random random = new Random();
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = basicWords[random.nextInt(basicWords.length)];
        }
        return words;
    }
}
