package models;

import java.util.Objects;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String contactInfo;
    private String address;

    public Doctor(int id, String name, String specialization, String contactInfo, String address) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(name, doctor.name) && Objects.equals(specialization, doctor.specialization) && Objects.equals(contactInfo, doctor.contactInfo) && Objects.equals(address, doctor.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, specialization, contactInfo, address);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Getters and Setters
    // Constructors
    // toString
}
