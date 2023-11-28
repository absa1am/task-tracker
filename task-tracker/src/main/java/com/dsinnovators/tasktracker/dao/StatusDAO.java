package com.dsinnovators.tasktracker.dao;

import com.dsinnovators.tasktracker.models.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO extends DAO {

    private String insertSQL = "INSERT INTO Status (status) VALUES (?);";
    private String updateSQL = "UPDATE Status SET status = ? where id = ?;";
    private String selectSQL = "SELECT * FROM Status;";
    private String selectByIdSQL = "SELECT * FROM Status WHERE id = ?;";

    public void insert(String status) throws SQLException, ClassNotFoundException {
        if (!statusExist(status)) {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);

            preparedStatement.setString(1, status);

            preparedStatement.execute();
        }
    }

    public List<Status> getAll() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(selectSQL);
        ResultSet statusResult = preparedStatement.executeQuery();
        List<Status> status = new ArrayList<>();

        while (statusResult.next()) {
            Status s = new Status();

            s.setId(statusResult.getInt("id"));
            s.setStatus(statusResult.getString("status"));

            status.add(s);
        }

        return status;
    }

    public Status get(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(selectByIdSQL);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Status status = new Status();

        status.setId(resultSet.getInt("id"));
        status.setStatus(resultSet.getString("status"));

        return status;
    }

    public boolean statusExist(String status) throws SQLException, ClassNotFoundException {
        List<Status> statusList = getAll();

        for (Status s : statusList) {
            if (s.getStatus().equals(status))
                return true;
        }

        return false;
    }

}
