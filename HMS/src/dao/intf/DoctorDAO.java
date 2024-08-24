package dao.intf;

import models.Doctor;

import java.util.List;

public interface DoctorDAO {
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int id);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
}
