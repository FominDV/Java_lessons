package ru.fomin.state.impl;

import ru.fomin.Project;
import ru.fomin.state.ToDo;

public class CodeTodo implements ToDo {

    @Override
    public boolean doIt(Project project) {
        System.out.println("Program code was written");
        project.setToDo(new ReviewToDo());
        return true;
    }

}
