//package untuk keteraturan supaya semua class yg berhubungan dengan perusahaan
//(Karyawan, Developer, Manajer) berada dalam satu package yang sama.
package perusahaan;

public class Karyawan {

   //Kita membuat atribut dasar untuk class Karyawan
   //Disini saya menggunakan private agar hanya bisa diubah lewat getter dan setter
    private String idKaryawan;
    private String nama;
    private int    tahunMasuk;
    private double gajiPokok;
    private double ratingKinerja; 

  
    //Kemudian Konstruktor superclass dipanggil dulu lewat super() di subclass, setlah itu di inisialisasi
    public Karyawan(String idKaryawan, String nama, int tahunMasuk,
                    double gajiPokok, double ratingKinerja) {
        this.idKaryawan  = idKaryawan;
        this.nama        = nama;
        this.tahunMasuk  = tahunMasuk;
        this.gajiPokok   = gajiPokok;

       //Untuk Validasi, jika nilai tdk valid, maka akan di set ke default 3.0
        if (ratingKinerja < 1.0 || ratingKinerja > 5.0) {
            this.ratingKinerja = 3.0; 
        } else {
            this.ratingKinerja = ratingKinerja;
        }
    }
    //Getter, agar Developer dan Manajer bisa baca nilai ini lewat getRatingKinerja() dan setRatingKinerja()
    //getNama(), dll agar tdk melanggar encapsulation.
    public String getIdKaryawan()    { return idKaryawan; }
    public String getNama()          { return nama; }
    public int    getTahunMasuk()    { return tahunMasuk; }
    public double getGajiPokok()     { return gajiPokok; }
    public double getRatingKinerja() { return ratingKinerja; }

    //Setter, agar nilai atribut bisa diubah secara aman dari luar class.
    public void setIdKaryawan(String idKaryawan)   { this.idKaryawan = idKaryawan; }
    public void setNama(String nama)               { this.nama = nama; }
    public void setTahunMasuk(int tahunMasuk)      { this.tahunMasuk = tahunMasuk; }
    public void setGajiPokok(double gajiPokok)     { this.gajiPokok = gajiPokok; }

   //Sama seperti sebelumnya, untuk validasi, jika nilai tdk valid, maka akan di set ke default 3.0
    public void setRatingKinerja(double ratingKinerja) {
        if (ratingKinerja < 1.0 || ratingKinerja > 5.0) {
            this.ratingKinerja = 3.0;
        } else {
            this.ratingKinerja = ratingKinerja;
        }
    }

    //untuk hitung gaji total
    public double hitungGajiTotal() {
        final int TAHUN_SEKARANG = 2026;
        int masaKerja = TAHUN_SEKARANG - tahunMasuk;

       
        double bonusLoyalitas = 0.05 * gajiPokok * masaKerja;
        double totalGaji = gajiPokok + bonusLoyalitas;

        
        if (ratingKinerja < 2.5) {
            totalGaji *= 0.90;
        }

        return totalGaji;
    }

    //Untuk menampilkan informasi karyawan
    public void displayInfo() {
        System.out.println("=============================================");
        System.out.println("Tipe      : Karyawan");
        System.out.println("ID        : " + idKaryawan);
        System.out.println("Nama      : " + nama);
        System.out.println("Thn Masuk : " + tahunMasuk);
        System.out.printf ("Rating    : %.1f%n", ratingKinerja);
        System.out.printf ("Gaji Pokok: Rp %,.0f%n", gajiPokok);
    }
}