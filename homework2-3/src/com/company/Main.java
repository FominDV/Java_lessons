package com.company;

import java.util.*;

public class Main {
    static final String[] UNIQUE_WORDS = {"apple", "sap", "beer", "cash", "summer", "bus", "next", "people", "length", "data", "circle", "monkey", "master"};
    static Scanner read = new Scanner(System.in);
    static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        //Task 1
        String[] words = generateArrayOfWords(30, UNIQUE_WORDS);
        Set<String> setWords = new HashSet<>(Arrays.asList(words));
        //I made listWords, because the word "список" was in the task.
        List<String> listWords = new ArrayList<>(Arrays.asList(setWords.toArray(new String[setWords.size()])));
        System.out.println("Start array of the words:\n" + new ArrayList<>(Arrays.asList(words)));
        System.out.println("List of the unique words:\n" + listWords);
        quantityOfRepetition(generateMapOfWords(listWords, words));
        //Task 2
        System.out.println();
        printPhones(phoneBook);
        System.out.println();
        printEmail(phoneBook);
        System.out.println();
        userChangeFirstName();
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

    static void printPhones(PhoneBook phoneBook) {
        Set<String> persons = getPersonFirstNames(phoneBook);
        for (String personFirstName : persons) {
            System.out.println(personFirstName + "'s phones: " + phoneBook.getPhonesList(personFirstName));
        }
    }

    static void printEmail(PhoneBook phoneBook) {
        Set<String> persons = getPersonFirstNames(phoneBook);
        for (String personFirstName : persons) {
            System.out.println(personFirstName + "'s email: " + phoneBook.getEmailList(personFirstName));
        }
    }

    static Set<String> getPersonFirstNames(PhoneBook phoneBook) {
        Set<String> persons = new HashSet<>();
        for (int i = 0; i < phoneBook.getGeneratedPersons().length; i++) {
            persons.add(phoneBook.generatePersons()[i].getFirstName());
        }
        return persons;
    }

    static void userChangeFirstName() {
        String firstNameEnteredByUser;
        while (true) {
            System.out.println("Enter '0' for exit\nEnter Firstname: from " + getPersonFirstNames(phoneBook));
            firstNameEnteredByUser = read.nextLine();
            if (firstNameEnteredByUser.equals("0")) {
                break;
            } else {
                System.out.println(phoneBook.getPhonesList(firstNameEnteredByUser));
                System.out.println(phoneBook.getEmailList(firstNameEnteredByUser));
            }

        }
    }
}
