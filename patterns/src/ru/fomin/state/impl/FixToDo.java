package ru.fomin.state.impl;

import ru.fomin.Project;
import ru.fomin.state.ToDo;

public class FixToDo implements ToDo {

    @Override
    public boolean doIt(Project project) {
        System.out.println("Program code was fixed");
        project.setToDo(new TestToDo());
        return true;
    }

}
