import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Register {
    public static boolean registerUser(String enrollmentNumber, String name, String roomNo, String email, String password, long phoneNumber) {
        String query = "INSERT INTO customer (enrollment_number, name, room_no, registered_email, user_password, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

try (Connection con = DatabaseConnection.getConnection();
     PreparedStatement pst = con.prepareStatement(query)) {

    pst.setString(1, enrollmentNumber);
    pst.setString(2, name);
    pst.setString(3, roomNo);
    pst.setString(4, email);
    pst.setString(5, password);
    pst.setLong(6, phoneNumber);

    int rowsInserted = pst.executeUpdate();

    if (rowsInserted > 0) {
        System.out.println("Registration successful! You can now log in.");
        return true;
    } else {
        System.out.println("Registration failed. Please try again.");
        return false;
    }
}
 catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
