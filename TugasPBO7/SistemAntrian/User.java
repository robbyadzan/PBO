public abstract class User {
    protected String nama;

    public User(String nama) {
        this.nama = nama;
    }

    public abstract void tampil();
}