package com.absalam.tasktracker.dao;

import java.sql.PreparedStatement;

public class TableCreateDAO extends DAO {

    private String createTableSQL = "CREATE TABLE IF NOT EXISTS Tasks(" +
            "id SERIAL PRIMARY KEY," +
            "name VARCHAR(50) NOT NULL," +
            "description VARCHAR(500)," +
            "start_date DATE NOT NULL," +
            "end_date DATE NOT NULL," +
            "status VARCHAR(25) NOT NULL);";

    public void seed() {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(createTableSQL)) {
            preparedStatement.executeUpdate();
        } catch (Exception exp) {
            throw new RuntimeException();
        }
    }

}
