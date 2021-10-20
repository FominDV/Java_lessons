package ru.fomin.employers.impl.sberbank;

import ru.fomin.employers.Analyst;

public class SberbankAnalyst implements Analyst {

    @Override
    public String createDocumentation() {
        return "Big documentation was created and it is being updated now";
    }

    @Override
    public String createTechnicalSpecification(String description) {
        return "Detailed documentation was created";
    }

}
