package ru.fomin.state.impl;

import ru.fomin.Project;
import ru.fomin.state.ToDo;

public class ReviewToDo implements ToDo {

    @Override
    public boolean doIt(Project project) {
        System.out.println("Program code was reviewed");
        project.setToDo(new FixToDo());
        return true;
    }

}
