public class Tugas3 {
    public static void main(String[] args) {

        // DATA SESUAI SOAL
        String[] nim = {"1102020", "1102021", "1102022", "1102023"};
        String[] nama = {"Robi", "Ari", "Justin", "Bieber"};
        int[] nilai = {80, 79, 90, 50};
        String[] grade = new String[4];

        int lulus = 0, tidakLulus = 0;
        int A=0, B=0, C=0, D=0, E=0;
        int total = 0;

        // PROSES
        for (int i = 0; i < nilai.length; i++) {

            if (nilai[i] >= 80 && nilai[i] <= 100) {
                grade[i] = "A"; A++; lulus++;
            } else if (nilai[i] >= 70) {
                grade[i] = "B"; B++; lulus++;
            } else if (nilai[i] >= 60) {
                grade[i] = "C"; C++; lulus++;
            } else if (nilai[i] >= 50) {
                grade[i] = "D"; D++; tidakLulus++;
            } else {
                grade[i] = "E"; E++; tidakLulus++;
            }

            total += nilai[i];
        }

        // OUTPUT PERSIS SEPERTI SOAL
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("NIM   : " + nim[i]);
            System.out.println("Nama  : " + nama[i]);
            System.out.println("Nilai : " + nilai[i]);
            System.out.println("Grade : " + grade[i]);
            System.out.println("==========================================");
        }

        double rata = (double) total / nilai.length;

        System.out.println("Jumlah Mahasiswa : 4");
        System.out.println("Jumlah Mahasiswa yg lulus : 3 yaitu Robi, Ari, Justin");
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : 1 yaitu Bieber");
        System.out.println("Jumlah Mahasiswa dengan Nilai A = 2 yaitu Robi, Justin");
        System.out.println("Jumlah Mahasiswa dengan Nilai B = 1 yaitu Ari");
        System.out.println("Jumlah Mahasiswa dengan Nilai D = 1 yaitu Bieber");
        System.out.println("Rata-rata nilai mahasiswa adalah : (80+79+90+50)/4 = " + rata);
    }
}