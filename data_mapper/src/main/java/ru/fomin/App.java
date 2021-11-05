package ru.fomin;

import ru.fomin.entities.Cat;
import ru.fomin.mapper.impl.CatMapper;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Cat cat1 = new Cat();
        cat1.setName("Barsick");
        cat1.setWeight(6);
        SqlConnector.connect();
        CatMapper catMapper = new CatMapper();
        catMapper.create(cat1);
        Cat cat2 = catMapper.findById(1L).get();
        System.out.println(cat2);
        System.out.println(catMapper.findAll());
    }

}
