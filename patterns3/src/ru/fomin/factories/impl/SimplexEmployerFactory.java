package ru.fomin.factories.impl;

import ru.fomin.employers.Analyst;
import ru.fomin.employers.Backend;
import ru.fomin.employers.Frontend;
import ru.fomin.employers.impl.simplex.SimplexAnalyst;
import ru.fomin.employers.impl.simplex.SimplexBackend;
import ru.fomin.employers.impl.simplex.SimplexFronted;
import ru.fomin.factories.EmployerFactory;

public class SimplexEmployerFactory implements EmployerFactory {

    @Override
    public Analyst getAnalyst() {
        return new SimplexAnalyst();
    }

    @Override
    public Backend getBackend() {
        return new SimplexBackend();
    }

    @Override
    public Frontend getFrontend() {
        return new SimplexFronted();
    }

}
