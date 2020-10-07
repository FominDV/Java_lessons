package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class PhoneBook {
    static HashMap<String, ArrayList<ArrayList<String>>> contacts = new HashMap<>();

    PhoneBook() {
        initialisation();
    }

    static void initialisation() {
        Person[] persons = generatePersons();
        Arrays.sort(persons);
        int hashFirstName = 0;
        for (Person person : persons) {
            ArrayList<String> phone = new ArrayList<>();
            ArrayList<String> email = new ArrayList<>();
            if (person.getHashFirstName() == hashFirstName) {
                for (Person personInto : persons) {
                    if (personInto.getHashFirstName() == hashFirstName) {
                        phone.add(personInto.getPhone());
                        email.add(personInto.getEmail());
                    }
                }
                ArrayList<ArrayList<String>> bufferContacts = new ArrayList<>();
                bufferContacts.add(phone);
                bufferContacts.add(email);
                contacts.put(person.getFirstName(), bufferContacts);
            } else {
                phone.add(person.getPhone());
                email.add(person.getEmail());
                contacts.put(person.getFirstName(), new ArrayList<>(Arrays.asList(phone, email)));
                hashFirstName = person.getHashFirstName();
            }

        }
    }

    static Person[] getGeneratedPersons() {
        return generatePersons();
    }

    static Person[] generatePersons() {
        Person[] persons = new Person[9];
        persons[0] = new Person("Ivanov", "Oleg", "74953334102", "mailrrr@yandex.ru");
        persons[1] = new Person("Gunonov", "Oleg", "74953334453", "mail4453@yandex.ru");
        persons[2] = new Person("Ivanov", "Mike", "74953334222", "mail212@yandex.ru");
        persons[3] = new Person("Galinova", "Olga", "74953334111", "mail400@yandex.ru");
        persons[4] = new Person("Galinova", "Oksana", "74953334234", "mail23w@yandex.ru");
        persons[5] = new Person("Garova", "Viktoria", "74953334213", "mail2dd2@yandex.ru");
        persons[6] = new Person("Ivanov", "Peter", "74953334210", "mail2354@yandex.ru");
        persons[7] = new Person("Sandrova", "Maria", "74953334217", "mail23459@yandex.ru");
        persons[8] = new Person("Fomina", "Sofia", "74953334000", "mail888@yandex.ru");
        return persons;
    }

    static ArrayList<String> getPhonesList(Person person) {
        for (Map.Entry<String, ArrayList<ArrayList<String>>> entryPhone : contacts.entrySet()) {
            if (entryPhone.getKey().equals(person.getFirstName())) {
                return entryPhone.getValue().get(0);
            }
        }
        return null;
    }

    static ArrayList<String> getEmailList(Person person) {
        for (Map.Entry<String, ArrayList<ArrayList<String>>> entryEmail : contacts.entrySet()) {
            if (entryEmail.getKey().equals(person.getFirstName())) {
                return entryEmail.getValue().get(1);
            }
        }
        return null;
    }
}
