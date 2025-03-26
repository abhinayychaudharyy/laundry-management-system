import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        String enrollmentNumber = "";

        System.out.println("--- Welcome to Laundry Management System ---");
        System.out.println("Press 1 for Registration");
        System.out.println("Press 2 for Login");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Removed bag number input
System.out.println("\n--- User Registration ---");
System.out.print("Enter Enrollment Number: ");
enrollmentNumber = scanner.next();
System.out.print("Enter Name: ");
String name = scanner.next();
System.out.print("Enter Room Number: ");
String roomNo = scanner.next();
System.out.print("Enter Email: ");
String email = scanner.next();
System.out.print("Enter Password: ");
String password = scanner.next();
System.out.print("Enter Phone Number: ");
long phoneNumber = scanner.nextLong();

boolean isRegistered = Register.registerUser(enrollmentNumber, name, roomNo, email, password, phoneNumber);

            if (!isRegistered) {
                System.out.println("Registration failed. Exiting...");
                return;
            }
        }

        // Login
        System.out.println("\n--- User Login ---");
        while (!isLoggedIn) {
            System.out.print("Enter Email: ");
            String loginEmail = scanner.next();
            System.out.print("Enter Password: ");
            String loginPassword = scanner.next();

            isLoggedIn = Login.authenticateUser(loginEmail, loginPassword);
        }

        // Order Placement
        System.out.println("\n--- Place Order ---");
        OrderPlacement.placeOrder();

        // Initialize Tracking
        //Tracking.initializeTracking(Login.getLoggedInEnrollmentNumber());

        // Update Laundry Summary
        System.out.println("\n--- Updating Laundry Summary ---");
        LaundrySummary.updateTotalCloths();

        scanner.close();
    }
}
