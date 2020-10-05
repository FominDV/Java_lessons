package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    static Map<Person, ArrayList<String>> phoneAndEmail = new HashMap<>();

    PhoneBook() {
        initialisation();
    }

    static void initialisation() {
        Person[] persons = generatePersons();
        for (int i = 0; i < persons.length; i++) {
            phoneAndEmail.put(persons[i], new ArrayList<>(Arrays.asList("74953334" + i + i / 2 + i, "mail" + i + i / 2 + i + "@yandex.ru")));
        }
    }

    static Person[] getGeneratedPersons() {
        return generatePersons();
    }

    static Person[] generatePersons() {
        Person[] persons = new Person[9];
        persons[0] = new Person("Ivanov", "Oleg");
        persons[1] = new Person("Belov", "Oleg");
        persons[2] = new Person("Ivanov", "Mike");
        persons[3] = new Person("Galinova", "Olga");
        persons[4] = new Person("Galinova", "Oksana");
        persons[5] = new Person("Garova", "Viktoria");
        persons[6] = new Person("Ivanov", "Peter");
        persons[7] = new Person("Sandrova", "Maria");
        persons[8] = new Person("Fomina", "Sofia");
        return persons;
    }

    static ArrayList<String> getPhonesList(Person person) {
        ArrayList<String> phonesList = new ArrayList<>();
        for (Map.Entry<Person, ArrayList<String>> entryPhone : phoneAndEmail.entrySet()) {
            if (entryPhone.getKey().equals(person)) {
                phonesList.add(entryPhone.getValue().get(0));
            }
        }
        return phonesList;
    }

    static ArrayList<String> getEmailList(Person person) {
        ArrayList<String> emailList = new ArrayList<>();
        for (Map.Entry<Person, ArrayList<String>> entryEmail : phoneAndEmail.entrySet()) {
            if (entryEmail.getKey().equals(person)) {
                emailList.add(entryEmail.getValue().get(1));
            }
        }
        return emailList;
    }
}
