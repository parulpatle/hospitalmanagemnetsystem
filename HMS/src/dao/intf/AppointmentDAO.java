package dao.intf;

import models.Appointment;

import java.util.List;

public interface AppointmentDAO {
    void addAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int id);
    Appointment getAppointmentById(int id);
    List<Appointment> getAppointmentsByDoctor(int doctorId);
    List<Appointment> getAppointmentsByPatient(int patientId);
}
