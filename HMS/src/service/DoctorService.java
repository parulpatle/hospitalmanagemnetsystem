package service;

import dao.factory.DoctorDAOFactory;
import dao.factory.ScheduleDAOFactory;
import dao.intf.DoctorDAO;
import dao.intf.ScheduleDAO;
import models.Doctor;

import java.io.File;
import java.io.IOException;
import java.util.List;
//import com.fasterxml.jackson.databind.ObjectMapper;


public class DoctorService {

    private DoctorDAO doctorDAO;
    private ScheduleDAO scheduleDAO;

    public DoctorService() {
        this.doctorDAO = new DoctorDAOFactory().createDoctorDAO();
        this.scheduleDAO = new ScheduleDAOFactory().createScheduleDAO();
    }
    /*public void importDoctorsFromJson(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Doctor> doctors = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Doctor.class));
        for (Doctor doctor : doctors) {
            doctorDAO.addDoctor(doctor); // Insert doctor into the database
        }
        System.out.println("Doctors imported successfully from JSON.");
    }*/

    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    public Doctor getDoctorById(int id) {
        return doctorDAO.getDoctorById(id);
    }


    public void updateDoctor(Doctor doctor) {
        doctorDAO.updateDoctor(doctor);
    }

    public void deleteDoctor(int id) {
        doctorDAO.deleteDoctor(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    // Schedule-related methods
    public void addSchedule(int doctorId, String schedule) {
        scheduleDAO.addSchedule(doctorId, schedule);
    }

    public void updateSchedule(int doctorId, String newSchedule) {
        scheduleDAO.updateSchedule(doctorId, newSchedule);
    }

    public void removeSchedule(int doctorId) {
        scheduleDAO.removeSchedule(doctorId);
    }

    public List<String> getSchedules(int doctorId) {
        return scheduleDAO.getSchedules(doctorId);
    }
}
