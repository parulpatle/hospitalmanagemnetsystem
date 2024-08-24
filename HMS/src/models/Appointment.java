package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private String status; // scheduled, canceled, completed

    public Appointment(int id, Patient patient, Doctor doctor, LocalDate date, LocalTime time, String status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && Objects.equals(patient, that.patient) && Objects.equals(doctor, that.doctor) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, date, time, status);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", date=" + date +
                ", time=" + time +
                ", status='" + status + '\'' +
                '}';
    }

    // Getters and Setters
    // Constructors
    // toString
}
