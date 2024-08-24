package view;

import service.DoctorService;
import models.Doctor;

import java.util.List;
import java.util.Scanner;

public class DoctorView {

    private DoctorService doctorService;
    private Scanner scanner;

    public DoctorView() {
        this.doctorService = new DoctorService();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Doctor Menu:");
            System.out.println("1. Add Schedule");
            System.out.println("2. Update Schedule");
            System.out.println("3. View Appointments");
            System.out.println("4. Suggest Medical Test");
            System.out.println("5. Suggest Medicines");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addSchedule();
                    break;
                case 2:
                    updateSchedule();
                    break;
                case 3:
                    viewAppointments();
                    break;
                case 4:
                    suggestMedicalTest();
                    break;
                case 5:
                    suggestMedicines();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void addSchedule() {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Schedule: ");
        String schedule = scanner.nextLine();

        doctorService.addSchedule(doctorId, schedule);
        System.out.println("Schedule added.");
    }

    private void updateSchedule() {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter New Schedule: ");
        String newSchedule = scanner.nextLine();

        doctorService.updateSchedule(doctorId, newSchedule);
        System.out.println("Schedule updated.");
    }

    private void viewAppointments() {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Implement logic to view appointments here
        // For demonstration purposes, assume we print a placeholder message
        System.out.println("Viewing appointments for Doctor ID " + doctorId + ".");
    }

    private void suggestMedicalTest() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Test Suggestion: ");
        String testSuggestion = scanner.nextLine();

        // Implement logic to suggest medical test here
        System.out.println("Suggested medical test for Patient ID " + patientId + ": " + testSuggestion);
    }

    private void suggestMedicines() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Medicine Suggestion: ");
        String medicineSuggestion = scanner.nextLine();

        // Implement logic to suggest medicines here
        System.out.println("Suggested medicines for Patient ID " + patientId + ": " + medicineSuggestion);
    }
}
