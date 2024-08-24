package main;

import view.AdminView;
import view.DoctorView;
import view.UserView;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. Doctor Login");
            System.out.println("3. User Login");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    handleAdminLogin();
                    break;
                case 2:
                    handleDoctorLogin();
                    break;
                case 3:
                    handleUserLogin();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void handleAdminLogin() {
        // Simulate Admin login
        System.out.println("Admin logged in successfully.");
        AdminView adminView = new AdminView();
        adminView.displayMenu();
    }

    private static void handleDoctorLogin() {
        // Simulate Doctor login
        System.out.println("Doctor logged in successfully.");
        DoctorView doctorView = new DoctorView();
        doctorView.displayMenu();
    }

    private static void handleUserLogin() {
        // Simulate User login
        System.out.println("User logged in successfully.");
        UserView userView = new UserView();
        userView.displayMenu();
    }
}
