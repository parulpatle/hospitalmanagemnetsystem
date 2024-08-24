package dao.impl;

import dao.intf.ScheduleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false", "root", "Urmila@24");
    }

    @Override
    public void addSchedule(int doctorId, String schedule) {
        String sql = "INSERT INTO schedules (doctor_id, schedule) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            statement.setString(2, schedule);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSchedule(int doctorId, String newSchedule) {
        String sql = "UPDATE schedules SET schedule = ? WHERE doctor_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newSchedule);
            statement.setInt(2, doctorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeSchedule(int doctorId) {
        String sql = "DELETE FROM schedules WHERE doctor_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getSchedules(int doctorId) {
        String sql = "SELECT schedule FROM schedules WHERE doctor_id = ?";
        List<String> schedules = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                schedules.add(resultSet.getString("schedule"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
}
