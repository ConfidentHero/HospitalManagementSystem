package HospitalManagementSystem;

import java.util.Scanner;

public class Main {
    private static HospitalManager hospitalManager = new HospitalManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hospitalManager.addPatient(scanner);
                    break;
                case 2:
                    hospitalManager.viewPatients();
                    break;
                case 3:
                    hospitalManager.addDoctor(scanner);
                    break;
                case 4:
                    hospitalManager.viewDoctors();
                    break;
                case 5:
                    hospitalManager.scheduleAppointment(scanner);
                    break;
                case 6:
                    hospitalManager.viewAppointments();
                    break;
                case 7:
                    hospitalManager.admitPatient(scanner);
                    break;
                case 8:
                    hospitalManager.dischargePatient(scanner);
                    break;
                case 9:
                    hospitalManager.addMedicalRecord(scanner);
                    break;
                case 10:
                    hospitalManager.viewMedicalRecords();
                    break;
                case 11:
                    hospitalManager.generateBill(scanner);
                    break;
                case 12:
                    hospitalManager.viewBills();
                    break;
                case 13:
                    hospitalManager.searchPatient(scanner);
                    break;
                case 14:
                    hospitalManager.updatePatient(scanner);
                    break;
                case 15:
                    hospitalManager.generateHospitalReports();
                    break;
                case 0:
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Hospital Management System Menu ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add New Doctor");
        System.out.println("4. View All Doctors");
        System.out.println("5. Schedule Appointment");
        System.out.println("6. View All Appointments");
        System.out.println("7. Admit Patient");
        System.out.println("8. Discharge Patient");
        System.out.println("9. Add Medical Record");
        System.out.println("10. View Medical Records");
        System.out.println("11. Generate Bill");
        System.out.println("12. View All Bills");
        System.out.println("13. Search Patient");
        System.out.println("14. Update Patient Information");
        System.out.println("15. Generate Hospital Reports");
        System.out.println("0. Exit");
    }
}