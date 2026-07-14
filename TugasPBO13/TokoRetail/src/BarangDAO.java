import java.sql.*;
import java.util.ArrayList;

public class BarangDAO {

    // ==========================
    // TAMPIL DATA
    // ==========================
    public void tampilData() {

    try {

        Connection conn = Database.getConnection();

        String sql = "SELECT * FROM barang";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        int total = 0;

        System.out.println("\n==============================================================");
        System.out.printf("%-10s %-25s %-10s %-10s\n",
                "Kode", "Nama Barang", "Harga", "Stok");
        System.out.println("==============================================================");

        while (rs.next()) {

            System.out.printf("%-10s %-25s %-10d %-10d\n",
                    rs.getString("kode"),
                    rs.getString("nama_barang"),
                    rs.getInt("harga"),
                    rs.getInt("stok"));

            total++;

        }

        System.out.println("==============================================================");
        System.out.println("Total : " + total + " Barang");
        System.out.println("==============================================================");

        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

}

    // ==========================
    // TAMBAH DATA
    // ==========================
    public void tambahData(Barang barang) {

        try {

            Connection conn = Database.getConnection();

            String sql = "INSERT INTO barang VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, barang.getKode());
            ps.setString(2, barang.getNamaBarang());
            ps.setInt(3, barang.getHarga());
            ps.setInt(4, barang.getStok());

            ps.executeUpdate();

            System.out.println("\nData berhasil ditambahkan.");

            ps.close();
            conn.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ==========================
    // CARI DATA
    // ==========================
    public void cariData(String kode) {

        try {

            Connection conn = Database.getConnection();

            String sql = "SELECT * FROM barang WHERE kode=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kode);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nData Ditemukan");
                System.out.println("------------------------");
                System.out.println("Kode  : " + rs.getString("kode"));
                System.out.println("Nama  : " + rs.getString("nama_barang"));
                System.out.println("Harga : " + rs.getInt("harga"));
                System.out.println("Stok  : " + rs.getInt("stok"));

            } else {

                System.out.println("\nData tidak ditemukan.");

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ==========================
    // UBAH DATA
    // ==========================
    public void ubahData(Barang barang) {

        try {

            Connection conn = Database.getConnection();

            String sql =
                    "UPDATE barang SET nama_barang=?, harga=?, stok=? WHERE kode=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, barang.getNamaBarang());
            ps.setInt(2, barang.getHarga());
            ps.setInt(3, barang.getStok());
            ps.setString(4, barang.getKode());

            int hasil = ps.executeUpdate();

            if (hasil > 0) {

                System.out.println("\nData berhasil diubah.");

            } else {

                System.out.println("\nKode tidak ditemukan.");

            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ==========================
    // HAPUS DATA
    // ==========================
    public void hapusData(String kode) {

        try {

            Connection conn = Database.getConnection();

            String sql = "DELETE FROM barang WHERE kode=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kode);

            int hasil = ps.executeUpdate();

            if (hasil > 0) {

                System.out.println("\nData berhasil dihapus.");

            } else {

                System.out.println("\nKode tidak ditemukan.");

            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}