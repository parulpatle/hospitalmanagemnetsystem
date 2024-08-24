package models;

import java.util.Objects;

public class Patient {
    private int id;
    private String name;
    private String dob; // Date of Birth
    private String gender;
    private String contactInfo;
    private String address;

    public Patient(int id, String name, String dob, String gender, String contactInfo, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        Patient patient = (Patient) o;
        return id == patient.id && Objects.equals(name, patient.name) && Objects.equals(dob, patient.dob) && Objects.equals(gender, patient.gender) && Objects.equals(contactInfo, patient.contactInfo) && Objects.equals(address, patient.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob, gender, contactInfo, address);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Getters and Setters
    // Constructors
    // toString
}
