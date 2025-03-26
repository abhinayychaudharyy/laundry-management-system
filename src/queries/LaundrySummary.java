import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LaundrySummary {

    // Method to update total_cloths table with the latest summary
    public static void updateTotalCloths() {
        String countQuery = "SELECT SUM(kurta), SUM(pajama), SUM(shirt), SUM(t_shirt), SUM(pant), SUM(lower), SUM(shorts), " +
                "SUM(bedsheet), SUM(pillow_cover), SUM(towel), SUM(duppata), SUM(total_cloths) FROM order_table";

        String studentQuery = "SELECT " +
                "(SELECT COUNT(DISTINCT enrollment_number) FROM tracking_table) AS total_students, " +
                "(SELECT COUNT(DISTINCT enrollment_number) FROM tracking_table WHERE returned = TRUE) AS received_students, " +
                "(SELECT COUNT(DISTINCT enrollment_number) FROM tracking_table WHERE returned = FALSE) AS pending_students";

        String insertOrUpdateQuery = "INSERT INTO total_cloths (total_kurtas, total_pajama, total_shirt, total_t_shirt, " +
                "total_pant, total_lower, total_shorts, total_bedsheet, total_pillow_cover, total_towel, total_duppata, " +
                "net_cloths) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE total_kurtas = VALUES(total_kurtas), total_pajama = VALUES(total_pajama), " +
                "total_shirt = VALUES(total_shirt), total_t_shirt = VALUES(total_t_shirt), total_pant = VALUES(total_pant), " +
                "total_lower = VALUES(total_lower), total_shorts = VALUES(total_shorts), total_bedsheet = VALUES(total_bedsheet), " +
                "total_pillow_cover = VALUES(total_pillow_cover), total_towel = VALUES(total_towel), total_duppata = VALUES(total_duppata), " +
                "net_cloths = VALUES(net_cloths)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement countStmt = con.prepareStatement(countQuery);
             PreparedStatement studentStmt = con.prepareStatement(studentQuery);
             ResultSet countRs = countStmt.executeQuery();
             ResultSet studentRs = studentStmt.executeQuery();
             PreparedStatement insertOrUpdateStmt = con.prepareStatement(insertOrUpdateQuery)) {

            if (countRs.next() && studentRs.next()) {
                insertOrUpdateStmt.setLong(1, countRs.getLong(1));  // Total kurtas
                insertOrUpdateStmt.setLong(2, countRs.getLong(2));  // Total pajamas
                insertOrUpdateStmt.setLong(3, countRs.getLong(3));  // Total shirts
                insertOrUpdateStmt.setLong(4, countRs.getLong(4));  // Total t-shirts
                insertOrUpdateStmt.setLong(5, countRs.getLong(5));  // Total pants
                insertOrUpdateStmt.setLong(6, countRs.getLong(6));  // Total lowers
                insertOrUpdateStmt.setLong(7, countRs.getLong(7));  // Total shorts
                insertOrUpdateStmt.setLong(8, countRs.getLong(8));  // Total bedsheets
                insertOrUpdateStmt.setLong(9, countRs.getLong(9));  // Total pillow covers
                insertOrUpdateStmt.setLong(10, countRs.getLong(10)); // Total towels
                insertOrUpdateStmt.setLong(11, countRs.getLong(11)); // Total dupattas
                insertOrUpdateStmt.setLong(12, countRs.getLong(12)); // Net clothes count

                insertOrUpdateStmt.executeUpdate();
                System.out.println("Total clothes data updated successfully!");
                System.out.println("Total students submitted: " + studentRs.getInt(1));
                System.out.println("Total students received: " + studentRs.getInt(2));
                System.out.println("Total students pending: " + studentRs.getInt(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
