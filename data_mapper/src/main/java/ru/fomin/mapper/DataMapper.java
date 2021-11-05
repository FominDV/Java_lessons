package ru.fomin.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class DataMapper<T, ID> {

    protected HashMap<ID, T> identityMap = new HashMap<>();

    public abstract Optional<T> findById(ID id) throws SQLException, ClassNotFoundException;

    public abstract List<T> findAll() throws SQLException, ClassNotFoundException;

    public abstract void delete(ID id) throws SQLException, ClassNotFoundException;

    public abstract void create(T entity) throws SQLException, ClassNotFoundException;

}
