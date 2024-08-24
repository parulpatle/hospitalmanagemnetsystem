package dao.impl;

import dao.intf.ScheduleDAO;
import models.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "username", "password");
    }

    @Override
    public void addSchedule(Schedule schedule) {
        String sql = "INSERT INTO schedules (doctor_id, date, start_time, end_time) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, schedule.getDoctor().getId());
            statement.setDate(2, Date.valueOf(schedule.getDate()));
            statement.setTime(3, Time.valueOf(schedule.getStartTime()));
            statement.setTime(4, Time.valueOf(schedule.getEndTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        String sql = "UPDATE schedules SET doctor_id = ?, date = ?, start_time = ?, end_time = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, schedule.getDoctor().getId());
            statement.setDate(2, Date.valueOf(schedule.getDate()));
            statement.setTime(3, Time.valueOf(schedule.getStartTime()));
            statement.setTime(4, Time.valueOf(schedule.getEndTime()));
            statement.setInt(5, schedule.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSchedule(int id) {
        String sql = "DELETE FROM schedules WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Schedule getScheduleById(int id) {
        String sql = "SELECT * FROM schedules WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Schedule(
                    resultSet.getInt("id"),
                    new DoctorDAOImpl().getDoctorById(resultSet.getInt("doctor_id")),
                    resultSet.getDate("date").toLocalDate(),
                    resultSet.getTime("start_time").toLocalTime(),
                    resultSet.getTime("end_time").toLocalTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Schedule> getSchedulesByDoctor(int doctorId) {
        String sql = "SELECT * FROM schedules WHERE doctor_id = ?";
        List<Schedule> schedules = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                schedules.add(new Schedule(
                    resultSet.getInt("id"),
                    new DoctorDAOImpl().getDoctorById(resultSet.getInt("doctor_id")),
                    resultSet.getDate("date").toLocalDate(),
                    resultSet.getTime("start_time").toLocalTime(),
                    resultSet.getTime("end_time").toLocalTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
}
