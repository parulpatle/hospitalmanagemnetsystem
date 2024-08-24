package dao.impl;

import dao.intf.PatientDAO;
import models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false", "root", "Urmila@24");
    }

    @Override
    public void addPatient(Patient patient) {
        String sql = "INSERT INTO patients (name, dob, gender, contact_info, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getDob());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getContactInfo());
            statement.setString(5, patient.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        String sql = "UPDATE patients SET name = ?, dob = ?, gender = ?, contact_info = ?, address = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getDob());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getContactInfo());
            statement.setString(5, patient.getAddress());
            statement.setInt(6, patient.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Patient(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("dob"),
                    resultSet.getString("gender"),
                    resultSet.getString("contact_info"),
                    resultSet.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        String sql = "SELECT * FROM patients";
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                patients.add(new Patient(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("dob"),
                    resultSet.getString("gender"),
                    resultSet.getString("contact_info"),
                    resultSet.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
