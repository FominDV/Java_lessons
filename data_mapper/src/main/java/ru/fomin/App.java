package ru.fomin;

import ru.fomin.entities.Cat;
import ru.fomin.mapper.impl.CatMapper;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlConnector.connect();
        Cat cat1 = new Cat();
        cat1.setName("Barsick");
        cat1.setWeight(6);
        Cat cat2 = new Cat();
        cat2.setName("Musrick");
        cat2.setWeight(11);
        CatMapper catMapper = new CatMapper();
        catMapper.create(cat1);
        catMapper.create(cat2);
        Cat cat3 = catMapper.findById(1L).get();
        System.out.println(cat3);
        System.out.println(catMapper.findAll());
        catMapper.delete(cat3.getId());
        System.out.println(catMapper.findAll());
        SqlConnector.disconnect();
    }

}
