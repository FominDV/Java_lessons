package ru.fomin;

import ru.fomin.entities.SqlConnector;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlConnector.connect();
    }

}
