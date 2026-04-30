class Bank {

    // Overloading 1
    void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan);
    }

    // Overloading 2
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiaya(bankTujuan);
        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " bank " + bankTujuan);
        System.out.println("Biaya admin: " + biaya);
    }

    // Overloading 3
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biaya = hitungBiaya(bankTujuan);
        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " bank " + bankTujuan + " dengan berita: " + berita);
        System.out.println("Biaya admin: " + biaya);
    }

    // Method suku bunga default
    void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // BONUS: hitung biaya admin
    int hitungBiaya(String bankTujuan) {
        if (bankTujuan.equalsIgnoreCase("BNI")) {
            return 4000;
        } else if (bankTujuan.equalsIgnoreCase("BCA")) {
            return 5000;
        } else {
            return 6500; // bank lain
        }
    }
}

// =======================
// CLASS BNI (OVERRIDING)
// =======================
class BankBNI extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku Bunga BNI adalah 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiaya("BNI");
        System.out.println("[BNI] Transfer " + jumlah + " ke rekening " + rekeningTujuan);
        System.out.println("Biaya admin: " + biaya);
    }
}

// =======================
// CLASS BCA (OVERRIDING)
// =======================
class BankBCA extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku Bunga BCA adalah 4.5%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiaya("BCA");
        System.out.println("[BCA] Transfer " + jumlah + " ke rekening " + rekeningTujuan);
        System.out.println("Biaya admin: " + biaya);
    }
}

// =======================
// MAIN CLASS
// =======================
public class Tugas4 {
    public static void main(String[] args) {

        System.out.println("=== OVERLOADING ===");
        Bank bank = new Bank();

        bank.transferUang(100000, "22334455");
        System.out.println();

        bank.transferUang(200000, "44553321", "Mandiri");
        System.out.println();

        bank.transferUang(300000, "140124", "BRI", "Bayar Kuliah");
        System.out.println();

        bank.sukuBunga();

        System.out.println("\n=== OVERRIDING ===");

        Bank bni = new BankBNI();
        bni.sukuBunga();
        bni.transferUang(500000, "5544332", "BNI");

        System.out.println();

        Bank bca = new BankBCA();
        bca.sukuBunga();
        bca.transferUang(700000, "554432", "BCA");
    }
}