package COLLECTION_2;


import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {

        ArrayList<String> daftarNama = new ArrayList<>();

        daftarNama.add("Ferdi");
        daftarNama.add("Budi");
        daftarNama.add("Siti");

        System.out.println("=== ArrayList ===");
        for (String nama : daftarNama) {
            System.out.println("Nama: " + nama);
        }
    }
}