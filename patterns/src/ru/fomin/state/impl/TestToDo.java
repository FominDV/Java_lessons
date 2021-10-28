package ru.fomin.state.impl;

import ru.fomin.Project;
import ru.fomin.state.ToDo;

public class TestToDo implements ToDo {

    @Override
    public boolean doIt(Project project) {
        System.out.println("Program was tested");
        project.setToDo(new DemonstrateToDo());
        return true;
    }

}
