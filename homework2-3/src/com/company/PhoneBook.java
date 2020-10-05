package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    static Map<Person, String> phone = new HashMap<>();
    static Map<Person, String> email = new HashMap<>();

    PhoneBook() {
        initialisation();
    }

    static void initialisation() {
        Person[] persons = generatePersons();
        for (int i = 0; i < persons.length; i++) {
            phone.put(persons[i], "74953334" + i + i / 2 + i);
            email.put(persons[i], "mail" + i + i / 2 + i + "@yandex.ru");
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

    static ArrayList<String> getPhonesList(String firstName) {
        ArrayList<String> phonesList = new ArrayList<>();
        for (Map.Entry<Person, String> entryPhone : phone.entrySet()) {
            if (entryPhone.getKey().getFirstName().equals(firstName)) {
                phonesList.add(entryPhone.getValue());
            }
        }
        return phonesList;
    }

    static ArrayList<String> getEmailList(String firstName) {
        ArrayList<String> emailList = new ArrayList<>();
        for (Map.Entry<Person, String> entryEmail : email.entrySet()) {
            if (entryEmail.getKey().getFirstName().equals(firstName)) {
                emailList.add(entryEmail.getValue());
            }
        }
        return emailList;
    }
}
