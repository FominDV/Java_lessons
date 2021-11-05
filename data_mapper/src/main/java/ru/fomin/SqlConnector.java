package ru.fomin;

import org.flywaydb.core.Flyway;

import java.sql.*;

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

    public static PreparedStatement getPreparedStatement(String statementTemplate) throws SQLException, ClassNotFoundException {
        if (connection == null) {
            connect();
        }
        return connection.prepareStatement(statementTemplate);
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
