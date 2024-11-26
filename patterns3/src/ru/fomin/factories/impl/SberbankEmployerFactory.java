package ru.fomin.factories.impl;

import ru.fomin.employers.Analyst;
import ru.fomin.employers.Backend;
import ru.fomin.employers.Frontend;
import ru.fomin.employers.impl.sberbank.SberbankAnalyst;
import ru.fomin.employers.impl.sberbank.SberbankBackend;
import ru.fomin.employers.impl.sberbank.SberbankFrontend;
import ru.fomin.factories.EmployerFactory;

public class SberbankEmployerFactory implements EmployerFactory {

    @Override
    public Analyst getAnalyst() {
        return new SberbankAnalyst();
    }

    @Override
    public Backend getBackend() {
        return new SberbankBackend();
    }

    @Override
    public Frontend getFrontend() {
        return new SberbankFrontend();
    }

}
