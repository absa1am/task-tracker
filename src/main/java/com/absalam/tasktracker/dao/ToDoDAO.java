package com.absalam.tasktracker.dao;

import com.absalam.tasktracker.models.Status;
import com.absalam.tasktracker.models.Task;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO extends DAO {

    private String insertSQL = "INSERT INTO Tasks (name, description, start_date, end_date, status) VALUES (?, ?, ?, ?, ?);";
    private String updateSQL = "UPDATE Tasks SET name = ?, description = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?;";
    private String deleteSQL = "DELETE FROM Tasks WHERE id = ?";
    private String selectSQL = "SELECT * FROM Tasks;";
    private String selectByIdSQL = "SELECT * FROM Tasks WHERE id = ?;";

    public void insert(String name, String description, Date startDate, Date endDate, Status status) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDate(3, startDate);
            preparedStatement.setDate(4, endDate);
            preparedStatement.setString(5, String.valueOf(status));

            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String name, String description, Date startDate, Date endDate, Status status, int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(updateSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDate(3, startDate);
            preparedStatement.setDate(4, endDate);
            preparedStatement.setString(5, String.valueOf(status));
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Task get(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(selectByIdSQL)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setStartDate(resultSet.getDate("start_date"));
                task.setEndDate(resultSet.getDate("end_date"));
                task.setStatus(Status.valueOf(resultSet.getString("status")));

                return task;
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> getAll() {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(selectSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Task> tasks = new ArrayList<>();

            while (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setStartDate(resultSet.getDate("start_date"));
                task.setEndDate(resultSet.getDate("end_date"));
                task.setStatus(Status.valueOf(resultSet.getString("status")));

                tasks.add(task);
            }

            return tasks;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
