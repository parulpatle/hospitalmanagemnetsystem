package dao.impl;

import dao.intf.MedicalTestDAO;
import models.MedicalTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalTestDAOImpl implements MedicalTestDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "username", "password");
    }

    @Override
    public void addMedicalTest(MedicalTest medicalTest) {
        String sql = "INSERT INTO medical_tests (name, description) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medicalTest.getName());
            statement.setString(2, medicalTest.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicalTest(MedicalTest medicalTest) {
        String sql = "UPDATE medical_tests SET name = ?, description = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medicalTest.getName());
            statement.setString(2, medicalTest.getDescription());
            statement.setInt(3, medicalTest.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicalTest(int id) {
        String sql = "DELETE FROM medical_tests WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MedicalTest getMedicalTestById(int id) {
        String sql = "SELECT * FROM medical_tests WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new MedicalTest(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MedicalTest> getAllMedicalTests() {
        String sql = "SELECT * FROM medical_tests";
        List<MedicalTest> medicalTests = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                medicalTests.add(new MedicalTest(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalTests;
    }
}
