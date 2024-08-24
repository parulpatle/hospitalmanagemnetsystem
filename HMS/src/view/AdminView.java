package view;

import service.AdminService;
import service.DoctorService;
import models.Doctor;

import java.util.List;
import java.util.Scanner;
import java.io.File;


public class AdminView {

    private AdminService adminService;
    private DoctorService doctorService;
    private Scanner scanner;

    public AdminView() {
        this.adminService = new AdminService();
        this.doctorService = new DoctorService();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Import doctors");
            System.out.println("2. Show All Doctors");
            System.out.println("3. Update Doctor Schedule");
            System.out.println("4. Cancel Appointments");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    //importDoctors();
                    break;
                case 2:
                    showAllDoctors();
                    break;
                case 3:
                    updateDoctorSchedule();
                    break;
                case 4:
                    cancelAppointments();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    /*private void importDoctors() {
        System.out.print("Enter the file path to import doctors: ");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        try {
            doctorService.importDoctorsFromJson(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error importing doctors.");
        }
    }*/

    private void showAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private void updateDoctorSchedule() {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter New Schedule: ");
        String newSchedule = scanner.nextLine();

        doctorService.updateSchedule(doctorId, newSchedule);
        System.out.println("Schedule updated.");
    }

    private void cancelAppointments() {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Implement logic to view and cancel appointments here
        // For demonstration purposes, we assume appointments are canceled successfully
        System.out.println("Appointments for Doctor ID " + doctorId + " have been canceled.");
    }
}
