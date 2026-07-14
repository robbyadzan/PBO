import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BarangDAO dao = new BarangDAO();

        int pilih;

        do {

            System.out.println("\n--------------------------");
            System.out.println("       MENU TOKO RETAIL");
            System.out.println("----------------------------");
            System.out.println("1. Tampil Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Hapus Data");
            System.out.println("0. Keluar");
            System.out.println("----------------------------");
            System.out.print("Pilih Menu : ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:

                    dao.tampilData();

                    break;

                case 2:

                    Barang barangBaru = new Barang();

                    System.out.print("Kode Barang : ");
                    barangBaru.setKode(input.nextLine());

                    System.out.print("Nama Barang : ");
                    barangBaru.setNamaBarang(input.nextLine());

                    System.out.print("Harga : ");
                    barangBaru.setHarga(input.nextInt());

                    System.out.print("Stok : ");
                    barangBaru.setStok(input.nextInt());
                    input.nextLine();

                    dao.tambahData(barangBaru);

                    break;

                case 3:

                    System.out.print("Masukkan Kode Barang : ");
                    String kodeCari = input.nextLine();

                    dao.cariData(kodeCari);

                    break;

                case 4:

                    Barang barangEdit = new Barang();

                    System.out.print("Masukkan Kode Barang : ");
                    barangEdit.setKode(input.nextLine());

                    System.out.print("Nama Baru : ");
                    barangEdit.setNamaBarang(input.nextLine());

                    System.out.print("Harga Baru : ");
                    barangEdit.setHarga(input.nextInt());

                    System.out.print("Stok Baru : ");
                    barangEdit.setStok(input.nextInt());
                    input.nextLine();

                    dao.ubahData(barangEdit);

                    break;

                case 5:

                    System.out.print("Masukkan Kode Barang : ");
                    String kodeHapus = input.nextLine();

                    dao.hapusData(kodeHapus);

                    break;

                case 0:

                    System.out.println("\nTerima kasih telah menggunakan aplikasi.");

                    break;

                default:

                    System.out.println("\nMenu tidak tersedia.");

            }

        } while (pilih != 0);

        input.close();

    }

}