package com.company;

import java.util.*;

public class Main {
    static final String[] UNIQUE_WORDS = {"apple", "sap", "beer", "cash", "summer", "bus", "next", "people", "length", "data", "circle", "monkey", "master"};

    public static void main(String[] args) {
        //Task 1
        String[] words = generateArrayOfWords(30, UNIQUE_WORDS);
        Set<String> setWords = new HashSet<>(Arrays.asList(words));
        //I made listWords, because the word "список" was in the task.
        List<String> listWords = new ArrayList<>(Arrays.asList(setWords.toArray(new String[setWords.size()])));
        System.out.println("Start array of the words:\n" + new ArrayList<>(Arrays.asList(words)));
        System.out.println("List of the unique words:\n" + listWords);
        quantityOfRepetition(generateMapOfWords(listWords, words));

    }

    static String[] generateArrayOfWords(int size, String[] basicWords) {
        Random random = new Random();
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = basicWords[random.nextInt(basicWords.length)];
        }
        return words;
    }

    static HashMap<String, Integer> generateMapOfWords(List<String> listWords, String[] words) {
        HashMap<String, Integer> mapWords = new HashMap<>();
        int quantity;
        for (String listWord : listWords) {
            quantity = 0;
            for (String arrayWord : words) {
                if (listWord.equals(arrayWord)) {
                    mapWords.put(listWord, ++quantity);
                }
            }
        }
        return mapWords;
    }

    static void quantityOfRepetition(HashMap<String, Integer> mapWords) {
        for (Map.Entry<String, Integer> entryWord : mapWords.entrySet()) {
            System.out.println("The word '" + entryWord.getKey() + "' repeats into the list " + entryWord.getValue() + " times");
        }
    }
}
