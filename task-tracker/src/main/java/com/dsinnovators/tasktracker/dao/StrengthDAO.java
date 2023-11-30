package com.dsinnovators.tasktracker.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class StrengthDAO extends DAO {

    private String selectSQL = "SELECT status, COUNT(status) AS n FROM Tasks GROUP BY status;";

    public HashMap<String, Integer> get() {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(selectSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            HashMap<String, Integer> result = new HashMap<>();

            /*
             * Following data will be showed in the pie chart
             * Instead of using map, a DTO/record could be created, but I made it simple
             */
            result.put("Total", 0);
            result.put("Pending", 0);
            result.put("Processing", 0);
            result.put("Completed", 0);
            result.put("Backlog", 0);

            while (resultSet.next()) {
                String status = resultSet.getString("status");
                int n = resultSet.getInt("n");

                result.replace(status, n);
                result.replace("Total", result.get("Total") + n);
            }

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
