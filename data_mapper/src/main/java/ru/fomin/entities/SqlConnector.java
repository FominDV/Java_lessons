package ru.fomin.entities;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnector {

    private static final String URL_DATA_SOURCE = "jdbc:postgresql://localhost:5431/postgres";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private static Connection connection;
    private static Statement statement;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL_DATA_SOURCE, USER, PASSWORD);
        statement = connection.createStatement();
        Flyway flyway = Flyway.configure().envVars().dataSource(URL_DATA_SOURCE, USER, PASSWORD).load();
        flyway.migrate();
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }

    public static Statement getStatement() throws SQLException, ClassNotFoundException {
        if (statement == null) {
            connect();
        }
        return statement;
    }

}
