import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OrderPlacement {
    public static void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bag number: ");
        int bagNum = scanner.nextInt();

        System.out.print("Enter number of kurtas: ");
        int kurta = scanner.nextInt();
        System.out.print("Enter number of pajamas: ");
        int pajama = scanner.nextInt();
        System.out.print("Enter number of shirts: ");
        int shirt = scanner.nextInt();
        System.out.print("Enter number of t-shirts: ");
        int tShirt = scanner.nextInt();
        System.out.print("Enter number of pants: ");
        int pant = scanner.nextInt();
        System.out.print("Enter number of lowers: ");
        int lower = scanner.nextInt();
        System.out.print("Enter number of shorts: ");
        int shorts = scanner.nextInt();
        System.out.print("Enter number of bedsheets: ");
        int bedsheet = scanner.nextInt();
        System.out.print("Enter number of pillow covers: ");
        int pillowCover = scanner.nextInt();
        System.out.print("Enter number of towels: ");
        int towel = scanner.nextInt();
        System.out.print("Enter number of duppatas: ");
        int duppata = scanner.nextInt();

        int totalCloths = kurta + pajama + shirt + tShirt + pant + lower + shorts + bedsheet + pillowCover + towel + duppata;
        byte[] qrCode = generateDummyQR(String.valueOf(bagNum));

        String query = "INSERT INTO order_table (bag_num, kurta, pajama, shirt, t_shirt, pant, lower, shorts, bedsheet, pillow_cover, towel, duppata, total_cloths, qr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, bagNum);
            pst.setInt(2, kurta);
            pst.setInt(3, pajama);
            pst.setInt(4, shirt);
            pst.setInt(5, tShirt);
            pst.setInt(6, pant);
            pst.setInt(7, lower);
            pst.setInt(8, shorts);
            pst.setInt(9, bedsheet);
            pst.setInt(10, pillowCover);
            pst.setInt(11, towel);
            pst.setInt(12, duppata);
            pst.setInt(13, totalCloths);
            pst.setBytes(14, qrCode);

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Order placed successfully!");
            } else {
                System.out.println("Failed to place order!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] generateDummyQR(String bagNum) {
        return ("QR-" + bagNum).getBytes();
    }
}
