import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/toko_retail";
    private static final String USER = "root";
    private static final String PASSWORD = "Uud1945!@#";

    // Load driver secara statis
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver MySQL berhasil dimuat");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan : " + e.getMessage());
        }
    }

    public static Connection getConnection() {

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi berhasil!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Koneksi gagal : " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

}