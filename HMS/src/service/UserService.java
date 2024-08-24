package service;

import dao.factory.PatientDAOFactory;
import dao.intf.PatientDAO;
import models.Patient;

import java.util.List;

public class UserService {

    private PatientDAO patientDAO;

    public UserService() {
        this.patientDAO = new PatientDAOFactory().createPatientDAO();
    }

    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    public Patient getPatientById(int id) {
        return patientDAO.getPatientById(id);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}
