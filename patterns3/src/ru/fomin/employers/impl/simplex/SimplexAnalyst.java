package ru.fomin.employers.impl.simplex;

import ru.fomin.employers.Analyst;

public class SimplexAnalyst implements Analyst {

    @Override
    public String createDocumentation() {
        return "8-10 pages of user story";
    }

    @Override
    public String createTechnicalSpecification(String description) {
        return "Only list of used technologies";
    }

}
