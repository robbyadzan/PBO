import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        AntrianService antrian = new AntrianService();

        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();
                    antrian.tambahAntrian(nama);
                    break;
                case 2:
                    antrian.panggilAntrian();
                    break;
                case 3:
                    antrian.tampilkanAntrian();
                    break;
            }

        } while (pilihan != 0);

        System.out.println("Program selesai");
    }
}   