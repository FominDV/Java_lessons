package ru.fomin;

import ru.fomin.entities.Cat;
import ru.fomin.mapper.impl.CatMapper;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Cat cat1 = new Cat();
        cat1.setName("Murka");
        cat1.setWeight(11);
        SqlConnector.connect();
        CatMapper catMapper = new CatMapper();
        catMapper.create(cat1);
    }

}
