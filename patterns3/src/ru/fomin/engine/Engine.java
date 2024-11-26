package ru.fomin.engine;

import ru.fomin.employers.Analyst;
import ru.fomin.employers.Backend;
import ru.fomin.employers.Frontend;
import ru.fomin.factories.EmployerFactory;

public class Engine {

    private EmployerFactory employerFactory;
    private Analyst analyst;
    private Backend backend;
    private Frontend frontend;

    public Engine(EmployerFactory employerFactory) {
        this.employerFactory = employerFactory;
        analyst = employerFactory.getAnalyst();
        backend = employerFactory.getBackend();
        frontend = employerFactory.getFrontend();
    }

    public void execute() {
        System.out.println("Analyst work:");
        System.out.println(analyst.createTechnicalSpecification("task"));
        System.out.println(analyst.createDocumentation());
        System.out.println("Backend work:");
        backend.createControllers();
        backend.createOrm();
        backend.createDatabaseSchema();
        System.out.println("Frontend work:");
        System.out.println(frontend.writeHtml("specification"));
        frontend.writeJavaScriptCode("specification");
    }

}
