package GENERIC_1;

public class Mahasiswaku {
    public static void main(String[] args) {

        Mahasiswa<String, String, Integer> m = new Mahasiswa<>();

        m.setNim("1102020");
        m.setName("Ferdi");
        m.setClas(21);

        System.out.println("=== Data Mahasiswa ===");
        System.out.println("NIM   : " + m.getNim());
        System.out.println("Nama  : " + m.getName());
        System.out.println("Kelas : " + m.getClas());
    }
}