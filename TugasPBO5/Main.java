import java.util.Scanner;

// SUPER CLASS
class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return name + " (" + address + ")";
    }
}

// STUDENT
class Student extends Person {
    private String[] courses = new String[100];
    private int[] grades = new int[100];
    private int numCourses = 0;

    public Student(String name, String address) {
        super(name, address);
    }

    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    public void printGrades() {
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + " : " + grades[i]);
        }
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}

// TEACHER
class Teacher extends Person {
    private String[] courses = new String[100];
    private int numCourses = 0;

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                return false; // sudah ada
            }
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                numCourses--;
                return true;
            }
        }
        return false; // tidak ditemukan
    }

    public void printCourses() {
        if (numCourses == 0) {
            System.out.println("Tidak ada mata kuliah");
        } else {
            System.out.println("Mata Kuliah:");
            for (int i = 0; i < numCourses; i++) {
                System.out.println("- " + courses[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}

// MAIN
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // =====================
        // INPUT MAHASISWA
        // =====================
        System.out.println("=== INPUT MAHASISWA ===");
        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Alamat: ");
        String alamat = input.nextLine();

        Student s = new Student(nama, alamat);

        System.out.print("Jumlah Mata Kuliah: ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Nama MK: ");
            String mk = input.nextLine();

            System.out.print("Nilai: ");
            int nilai = input.nextInt();
            input.nextLine();

            s.addCourseGrade(mk, nilai);
        }

        // =====================
        // OUTPUT MAHASISWA
        // =====================
        System.out.println("\n=== DATA MAHASISWA ===");
        System.out.println(s);
        s.printGrades();
        System.out.println("Rata-rata: " + s.getAverageGrade());

        // =====================
        // INPUT DOSEN
        // =====================
        System.out.println("\n=== INPUT DOSEN ===");
        System.out.print("Nama: ");
        String namaDosen = input.nextLine();

        System.out.print("Alamat: ");
        String alamatDosen = input.nextLine();

        Teacher t = new Teacher(namaDosen, alamatDosen);

        // tambah course
        System.out.print("Tambah Mata Kuliah: ");
        String mkTambah = input.nextLine();

        if (t.addCourse(mkTambah)) {
            System.out.println("Mata kuliah berhasil ditambahkan");
        } else {
            System.out.println("Mata kuliah sudah ada!");
        }

        // coba tambah lagi (biar kelihatan validasi)
        System.out.print("Tambah Mata Kuliah lagi: ");
        String mkTambah2 = input.nextLine();

        if (t.addCourse(mkTambah2)) {
            System.out.println("Mata kuliah berhasil ditambahkan");
        } else {
            System.out.println("Mata kuliah sudah ada!");
        }

        // hapus course
        System.out.print("Hapus Mata Kuliah: ");
        String mkHapus = input.nextLine();

        if (t.removeCourse(mkHapus)) {
            System.out.println("Mata kuliah berhasil dihapus");
        } else {
            System.out.println("Mata kuliah tidak ditemukan!");
        }

        // =====================
        // OUTPUT DOSEN
        // =====================
        System.out.println("\n=== DATA DOSEN ===");
        System.out.println(t);
        t.printCourses();

        input.close();
    }
}