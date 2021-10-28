package ru.fomin.state.impl;

import ru.fomin.Project;
import ru.fomin.state.ToDo;

public class DemonstrateToDo implements ToDo {

    private boolean isDemonstrated;

    @Override
    public boolean doIt(Project project) {
        if (!isDemonstrated) {
            System.out.println("Program is ready and demonstrated");
            isDemonstrated = true;
        }
        return false;
    }

}
