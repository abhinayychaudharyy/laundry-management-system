import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Laundry_Management", "root", "vasudeva");
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
