package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private String status; // scheduled, canceled, completed

    // Getters and Setters
    // Constructors
    // toString
}
