package ru.fomin.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DataMapper<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    void delete(ID id);

    void create(T entity) throws SQLException, ClassNotFoundException;

}
