package ru.fomin.state.impl;

import ru.fomin.Project;
import ru.fomin.state.ToDo;

public class SpecificationToDo implements ToDo {

    @Override
    public boolean doIt(Project project) {
        System.out.println("Specification for the project was created");
        project.setToDo(new CodeTodo());
        return true;
    }

}
