package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Schedule {
    private int id;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule(int id, Doctor doctor, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.doctor = doctor;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return id == schedule.id && Objects.equals(doctor, schedule.doctor) && Objects.equals(date, schedule.date) && Objects.equals(startTime, schedule.startTime) && Objects.equals(endTime, schedule.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, date, startTime, endTime);
    }

    // Getters and Setters
    // Constructors
    // toString
}
