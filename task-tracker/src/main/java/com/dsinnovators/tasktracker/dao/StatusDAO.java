package com.dsinnovators.tasktracker.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusDAO extends DAO {

    private String insertSQL = "INSERT INTO Status (status) VALUES (?);";
    private String updateSQL = "UPDATE Status SET status = ? where id = ?;";
    private String selectSQL = "SELECT * FROM Status;";
    private String selectByIdSQL = "SELECT * FROM Status WHERE id = ?;";

    public void insert(String status) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);

        preparedStatement.setString(1, status);

        preparedStatement.execute();
    }

}
