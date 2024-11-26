package ru.fomin;

import ru.fomin.engine.Engine;
import ru.fomin.factories.impl.SberbankEmployerFactory;
import ru.fomin.factories.impl.SimplexEmployerFactory;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Engine engine;
        Random random = new Random();
        engine = random.nextBoolean() ? new Engine(new SberbankEmployerFactory()) : new Engine(new SimplexEmployerFactory());
        engine.execute();
    }
}
