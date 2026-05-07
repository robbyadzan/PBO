import java.util.ArrayDeque;

public class AntrianService implements Antrian {

    private ArrayDeque<Pelanggan> queue = new ArrayDeque<>();

    @Override
    public void tambahAntrian(String nama) {
        Pelanggan p = new Pelanggan(nama);
        queue.add(p);
        System.out.println(nama + " masuk antrian");
    }

    @Override
    public void panggilAntrian() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            Pelanggan p = queue.poll();
            System.out.println("Memanggil: " + p.getNama());
        }
    }

    @Override
    public void tampilkanAntrian() {
        if (queue.isEmpty()) {
            System.out.println("Tidak ada antrian");
        } else {
            System.out.println("Daftar Antrian:");
            for (Pelanggan p : queue) {
                System.out.println("- " + p.getNama());
            }
        }
    }
}