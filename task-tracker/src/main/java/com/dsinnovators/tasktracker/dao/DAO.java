package com.dsinnovators.tasktracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private String url = "jdbc:postgresql://localhost:5432/jdbc";
    private String username = "postgres";
    private String password = "123456";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        System.out.println(connection.isClosed());
        System.out.println(connection.isValid(0));
        
        return connection;
    }

}
