package com.dsinnovators.tasktracker.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAO {

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("database.properties");

        properties.load(inputStream);

        // retrieving database config
        String driver = properties.getProperty("database.driver");
        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");

        // ensuring driver loaded
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, username, password);
        
        return connection;
    }

}
