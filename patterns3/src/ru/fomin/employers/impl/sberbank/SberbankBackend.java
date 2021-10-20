package ru.fomin.employers.impl.sberbank;

import ru.fomin.employers.Backend;

public class SberbankBackend implements Backend {

    @Override
    public void createControllers() {
        System.out.println("Spring-mvc controller was created");
    }

    @Override
    public void createOrm() {
        System.out.println("Was used spring-data");
    }

    @Override
    public void createDatabaseSchema() {
        System.out.println("Schemas was created");
    }

}
