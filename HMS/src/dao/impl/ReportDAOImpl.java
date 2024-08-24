package dao.impl;

import dao.intf.ReportDAO;
import models.Report;

public class ReportDAOImpl implements ReportDAO {

    @Override
    public Report generateDoctorReport() {
        // Dummy implementation for demonstration
        return new Report("Doctor Report", "This is a report of doctors.");
    }

    @Override
    public Report generateAppointmentReport() {
        // Dummy implementation for demonstration
        return new Report("Appointment Report", "This is a report of appointments.");
    }

    @Override
    public Report generatePatientReport() {
        // Dummy implementation for demonstration
        return new Report("Patient Report", "This is a report of patients.");
    }
}
