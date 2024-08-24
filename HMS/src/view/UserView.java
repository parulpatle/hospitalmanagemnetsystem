package view;

import models.Patient;
import service.UserService;
import models.User;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private UserService userService;
    private Scanner scanner;

    public UserView() {
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Book Appointment");
            System.out.println("3. View Appointments");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    bookAppointment();
                    break;
                case 3:
                    viewAppointments();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void addPatient() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        System.out.print("Enter Gender (M/F): ");
        String gender = scanner.nextLine();

        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Patient patient = new Patient(patientId, name, dob, gender, contactInfo, address);
        userService.addPatient(patient);
        System.out.println("Patient added.");
    }



    private void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Appointment Date: ");
        String appointmentDate = scanner.nextLine();

        // Implement logic to book appointment here
        System.out.println("Appointment booked for Patient ID " + patientId + " with Doctor ID " + doctorId + " on " + appointmentDate + ".");
    }

    private void viewAppointments() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Implement logic to view appointments here
        // For demonstration purposes, assume we print a placeholder message
        System.out.println("Viewing appointments for Patient ID " + patientId + ".");
    }
}
