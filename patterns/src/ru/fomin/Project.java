package ru.fomin;

import ru.fomin.state.ToDo;
import ru.fomin.state.impl.SpecificationToDo;

public class Project {

    private ToDo toDo = new SpecificationToDo();

    public boolean doNextStep() {
        return toDo.doIt(this);
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

}
