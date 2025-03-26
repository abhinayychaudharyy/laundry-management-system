// import java.sql.*;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

// public class Tracking {

//    // Method to initialize tracking when an order is placed
//    public static void initializeTracking(String enrollmentNumber) {
//        String query = "INSERT INTO tracking_table (enrollment_number, submition, in_process, ready, returned) VALUES (?, ?, ?, ?, ?)";

//        try (Connection con = DatabaseConnection.getConnection();
//             PreparedStatement pst = con.prepareStatement(query)) {

//            if (con == null) {
//                System.out.println("Database connection failed.");
//                return;
//            }

//            LocalDateTime now = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            String formattedDate = now.format(formatter);

//            pst.setString(1, enrollmentNumber);
//            pst.setString(2, formattedDate); // Submission Time
//            pst.setBoolean(3, false); // in_process
//            pst.setBoolean(4, false); // ready
//            pst.setBoolean(5, false); // returned

//            pst.executeUpdate();
//            System.out.println("Tracking Initialized for Enrollment Number: " + enrollmentNumber);

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    // Method to update tracking status
//    public static void updateTrackingStatus(String enrollmentNumber, boolean inProcess, boolean ready, boolean returned) {
//        String query = "UPDATE tracking_table SET in_process = ?, ready = ?, returned = ? WHERE enrollment_number = ?";

//        try (Connection con = DatabaseConnection.getConnection();
//             PreparedStatement pst = con.prepareStatement(query)) {

//            if (con == null) {
//                System.out.println("Database connection failed.");
//                return;
//            }

//            pst.setBoolean(1, inProcess);
//            pst.setBoolean(2, ready);
//            pst.setBoolean(3, returned);
//            pst.setString(4, enrollmentNumber);

//            pst.executeUpdate();
//            System.out.println("Tracking Updated for Enrollment Number: " + enrollmentNumber);

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    // Method to retrieve tracking details
//    public static void getTrackingDetails(String enrollmentNumber) {
//        String query = "SELECT * FROM tracking_table WHERE enrollment_number = ?";

//        try (Connection con = DatabaseConnection.getConnection();
//             PreparedStatement pst = con.prepareStatement(query)) {

//            if (con == null) {
//                System.out.println("Database connection failed.");
//                return;
//            }

//            pst.setString(1, enrollmentNumber);
//            ResultSet rs = pst.executeQuery();

//            if (rs.next()) {
//                System.out.println("Tracking Details for Enrollment Number: " + enrollmentNumber);
//                System.out.println("Submission Time: " + rs.getString("submition"));
//                System.out.println("In Process: " + rs.getBoolean("in_process"));
//                System.out.println("Ready: " + rs.getBoolean("ready"));
//                System.out.println("Returned: " + rs.getBoolean("returned"));
//            } else {
//                System.out.println("No tracking record found for Enrollment Number: " + enrollmentNumber);
//            }

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
// }
// public class Main {
//     public static void main(String[] args) {
//         String loggedInUser = "S24CSEU0110"; // Assume user is logged in

//         // Initialize tracking when order is placed
//         Tracking.initializeTracking(loggedInUser);

//         // Check tracking details
//         Tracking.getTrackingDetails(loggedInUser);

//         // Update status to "In Process"
//         Tracking.updateTrackingStatus(loggedInUser, true, false, false);

//         // Check tracking details again
//         Tracking.getTrackingDetails(loggedInUser);
//     }
// }
