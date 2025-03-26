import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    private static String loggedInEnrollmentNumber; // Stores the logged-in user's enrollment number

    public static boolean authenticateUser(String email, String password) {
        String query = "SELECT enrollment_number FROM customer WHERE registered_email = ? AND user_password = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            if (con == null) {
                System.out.println("Database connection failed.");
                return false;
            }

            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                loggedInEnrollmentNumber = rs.getString("enrollment_number");
                System.out.println("Login Successful! Enrollment Number: " + loggedInEnrollmentNumber);
                return true;
            } else {
                System.out.println("Invalid credentials! Try again.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getLoggedInEnrollmentNumber() {
        return loggedInEnrollmentNumber;
    }
}
