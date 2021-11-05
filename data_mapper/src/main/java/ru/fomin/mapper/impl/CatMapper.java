package ru.fomin.mapper.impl;

import ru.fomin.SqlConnector;
import ru.fomin.entities.Cat;
import ru.fomin.mapper.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatMapper extends DataMapper<Cat, Long> {

    private static final String CREATE_TEMPLATE = "INSERT INTO PUBLIC.CAT (NAME, WEIGHT) VALUES";
    private static final String FIND_TEMPLATE = "SELECT * FROM PUBLIC.CAT WHERE ID = ";
    private static final String FIND_ALL_TEMPLATE = "SELECT * FROM PUBLIC.CAT";
    private static final String DELETE_TEMPLATE = "DELETE FROM PUBLIC.CAT WHERE ID = ";

    @Override
    public Optional<Cat> findById(Long id) throws SQLException, ClassNotFoundException {
        Cat cat;
        if (identityMap.containsKey(id)) {
            cat = identityMap.get(id);
        } else {
            cat = new Cat();
            ResultSet resultSet = SqlConnector.getPreparedStatement(FIND_TEMPLATE + id).executeQuery();
            while (resultSet.next()) {
                collectCat(cat, resultSet);
            }
        }
        return Optional.of(cat);
    }

    @Override
    public List<Cat> findAll() throws SQLException, ClassNotFoundException {
        List<Cat> catList = new ArrayList<>();
        ResultSet resultSet = SqlConnector.getPreparedStatement(FIND_ALL_TEMPLATE).executeQuery();
        while (resultSet.next()) {
            Cat cat = new Cat();
            collectCat(cat, resultSet);
            catList.add(cat);
        }
        return catList;
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        SqlConnector.getStatement().executeUpdate(DELETE_TEMPLATE + id);
    }

    @Override
    public void create(Cat entity) throws SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder(CREATE_TEMPLATE);
        stringBuilder.append(" ('").append(entity.getName()).append("', ").append(entity.getWeight()).append(")");
        SqlConnector.getStatement().executeUpdate(stringBuilder.toString());
    }

    private Cat collectCat(Cat cat, ResultSet resultSet) throws SQLException {
        cat.setId(resultSet.getLong(1));
        cat.setName(resultSet.getString(2));
        cat.setWeight(resultSet.getInt(3));
        return cat;
    }

}
