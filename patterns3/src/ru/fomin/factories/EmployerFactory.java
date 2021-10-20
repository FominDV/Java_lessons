package ru.fomin.factories;

import ru.fomin.employers.Analyst;
import ru.fomin.employers.Backend;
import ru.fomin.employers.Frontend;

public interface EmployerFactory {

    Analyst getAnalyst();

    Backend getBackend();

    Frontend getFrontend();

}
