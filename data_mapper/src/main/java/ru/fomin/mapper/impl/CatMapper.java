package ru.fomin.mapper.impl;

import ru.fomin.SqlConnector;
import ru.fomin.entities.Cat;
import ru.fomin.mapper.DataMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CatMapper implements DataMapper<Cat, Long> {

    private static final String CREATE_TEMPLATE = "INSERT INTO PUBLIC.CAT (NAME, WEIGHT) VALUES";

    @Override
    public Optional<Cat> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Cat> findAll() {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void create(Cat entity) throws SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder(CREATE_TEMPLATE);
        stringBuilder.append(" ('").append(entity.getName()).append("', ").append(entity.getWeight()).append(")");
        SqlConnector.getStatement().executeUpdate(stringBuilder.toString());
    }
}
