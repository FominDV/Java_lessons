package ru.fomin.employers.impl.simplex;

import ru.fomin.employers.Backend;

public class SimplexBackend implements Backend {

    @Override
    public void createControllers() {
        System.out.println("JAX-RS controller was created");
    }

    @Override
    public void createOrm() {
        System.out.println("Was used hibernate ORM without spring-data");
    }

    @Override
    public void createDatabaseSchema() {
        System.out.println("Simply schemas was created");
    }

}
