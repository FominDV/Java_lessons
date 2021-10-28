package ru.fomin;

public class App {

    public static void main(String[] args) {
        Project project = new Project();
        while (project.doNextStep()) ;
    }

}
