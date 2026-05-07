public class Pelanggan extends User {

    public Pelanggan(String nama) {
        super(nama);
    }

    @Override
    public void tampil() {
        System.out.println("Pelanggan: " + nama);
    }

    public String getNama() {
        return nama;
    }
}