package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
    private String firstName;
    private String secondName;

    Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
    Person(String firstName) {
        this.firstName = firstName;
        secondName = "unknown";
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
}
