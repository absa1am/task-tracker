package com.dsinnovators.tasktracker.dao;

import com.dsinnovators.tasktracker.models.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoDAO extends DAO {

    private String insertSQL = "INSERT INTO Tasks (name, description, start_date, end_date, status_id) VALUES (?, ?, ?, ?, ?);";
    private String updateSQL = "UPDATE Tasks SET name = ?, description = ?, start_date = ?, end_date = ? WHERE id = ?;";
    private String selectSQL = "SELECT * FROM Tasks;";
    private String selectByIdSQL = "SELECT * FROM Tasks WHERE id = ?;";

    public void insert(String name, String description, Date startDate, Date endDate, int statusId) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDate(3, (java.sql.Date) startDate);
            preparedStatement.setDate(4, (java.sql.Date) endDate);
            preparedStatement.setInt(5, statusId);

            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> getAll() {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Task> tasks = new ArrayList<>();

            while (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setStartDate(resultSet.getDate("start_date"));
                task.setEndDate(resultSet.getDate("end_date"));
                task.setStatusId(resultSet.getInt("status_id"));

                tasks.add(task);
            }

            return tasks;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
