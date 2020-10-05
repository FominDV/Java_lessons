package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String secondName;
    private String phone;
    private String email;
    private int hashFirstName;

    Person(String firstName, String secondName, String phone, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone=phone;
        this.email=email;
        hashFirstName=getId(firstName);
    }
    Person(String firstName) {
        this.firstName = firstName;
        hashFirstName=getId(firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public int getHashFirstName() {
        return hashFirstName;
    }
    static private int getId(String firstName){
        int id=0;
        for(int i=0; i<firstName.length(); i++){
            id+=firstName.charAt(i);
        }
        return id;
    }

    @Override
    public int compareTo(Person o) {
       return (o==this)?0:hashFirstName-o.hashFirstName;
    }
}

