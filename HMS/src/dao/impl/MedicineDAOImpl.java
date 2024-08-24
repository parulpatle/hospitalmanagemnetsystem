package dao.impl;

import dao.intf.MedicineDAO;
import models.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAOImpl implements MedicineDAO {

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false", "root", "Urmila@24");
    }

    @Override
    public void addMedicine(Medicine medicine) {
        String sql = "INSERT INTO medicines (name, description, dosage) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medicine.getName());
            statement.setString(2, medicine.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        String sql = "UPDATE medicines SET name = ?, description = ?, dosage = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medicine.getName());
            statement.setString(2, medicine.getDescription());
            statement.setInt(4, medicine.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicine(int id) {
        String sql = "DELETE FROM medicines WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Medicine getMedicineById(int id) {
        String sql = "SELECT * FROM medicines WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Medicine(
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
    public List<Medicine> getAllMedicines() {
        String sql = "SELECT * FROM medicines";
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                medicines.add(new Medicine(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description")

                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }
}
