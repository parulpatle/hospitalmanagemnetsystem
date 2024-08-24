package models;

import java.util.List;
import java.util.Objects;

public class Report {
    private int id;
    private List<Doctor> doctorReports;
    private List<Appointment> appointmentReports;
    private List<Patient> patientReports;

    public Report(int id, List<Doctor> doctorReports, List<Appointment> appointmentReports, List<Patient> patientReports) {
        this.id = id;
        this.doctorReports = doctorReports;
        this.appointmentReports = appointmentReports;
        this.patientReports = patientReports;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public List<Doctor> getDoctorReports() {
        return doctorReports;
    }

    public void setDoctorReports(List<Doctor> doctorReports) {
        this.doctorReports = doctorReports;
    }

    public List<Appointment> getAppointmentReports() {
        return appointmentReports;
    }

    public void setAppointmentReports(List<Appointment> appointmentReports) {
        this.appointmentReports = appointmentReports;
    }

    public List<Patient> getPatientReports() {
        return patientReports;
    }

    public void setPatientReports(List<Patient> patientReports) {
        this.patientReports = patientReports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id == report.id && Objects.equals(doctorReports, report.doctorReports) && Objects.equals(appointmentReports, report.appointmentReports) && Objects.equals(patientReports, report.patientReports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorReports, appointmentReports, patientReports);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", doctorReports=" + doctorReports +
                ", appointmentReports=" + appointmentReports +
                ", patientReports=" + patientReports +
                '}';
    }

    // Getters and Setters
    // Constructors
    // toString
}
